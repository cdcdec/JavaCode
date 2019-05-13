package com.cdc.sample;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.SocketPolicy;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import static java.util.concurrent.TimeUnit.SECONDS;

public class RetrofitMain {
    public static void main(String[] args) throws Exception {
        transportProblemAsync();
    }

    private static void p(Object o) {
        System.out.println(o.toString());
    }

    private static void  doResponse(Response<String> response){
        p("响应码="+response.code());
        p("响应成功="+response.isSuccessful());
        p("响应toString="+response.toString());
        p("响应body="+response.body());
        p("请求地址="+response.raw().request().url().toString());
    }
    private static MockWebServer server=new MockWebServer();

    //同步请求
    public static void http200Sync() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(new ToStringConverterFactory())
                .build();
        Service example = retrofit.create(Service.class);
        server.enqueue(new MockResponse().setBody("Hi"));
        Response<String> response = example.getString().execute();
        doResponse(response);
    }
    //异步请求
    public static void http200Async() throws InterruptedException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(new ToStringConverterFactory())
                .build();
        Service example = retrofit.create(Service.class);
        server.enqueue(new MockResponse().setBody("Hi"));
        final AtomicReference<Response<String>> responseRef = new AtomicReference<>();
        final CountDownLatch latch = new CountDownLatch(1);
        example.getString().enqueue(new Callback<String>() {
             public void onResponse(Call<String> call, Response<String> response) {
                responseRef.set(response);
                latch.countDown();
            }
             public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }


        });
        //主线程等待10秒钟
       latch.await(20,SECONDS);
        Response<String> response = responseRef.get();
        doResponse(response);
    }

    public static void http404Async() throws InterruptedException, IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(new ToStringConverterFactory())
                .build();
        Service example = retrofit.create(Service.class);
        server.enqueue(new MockResponse().setResponseCode(404).setBody("Hi"));
        final AtomicReference<Response<String>> responseRef = new AtomicReference<>();
        final CountDownLatch latch = new CountDownLatch(1);
        example.getString().enqueue(new Callback<String>() {
            @Override public void onResponse(Call<String> call, Response<String> response) {
                responseRef.set(response);
                latch.countDown();
            }

            @Override public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });
        latch.await(10, SECONDS);
        Response<String> response = responseRef.get();
        doResponse(response);
    }

    public static void transportProblemAsync() throws InterruptedException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(new ToStringConverterFactory())
                .build();
        Service example = retrofit.create(Service.class);
        server.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_AT_START));
        final AtomicReference<Throwable> failureRef = new AtomicReference<>();
        final CountDownLatch latch = new CountDownLatch(1);
        example.getString().enqueue(new Callback<String>() {
            @Override public void onResponse(Call<String> call, Response<String> response) {
                throw new AssertionError();
            }
            @Override public void onFailure(Call<String> call, Throwable t) {
                failureRef.set(t);
                latch.countDown();
            }
        });
        latch.await(10, SECONDS);
        Throwable failure = failureRef.get();
        doThrowable(failure);
    }
    private static void doThrowable(Throwable throwable){
        p(throwable.toString());
        p(throwable.getMessage());
        p(throwable.getLocalizedMessage());

        StackTraceElement[] stackTraceElements=throwable.getStackTrace();
        p(stackTraceElements[0].getClassName());
        p(stackTraceElements[0].getLineNumber());
        p(stackTraceElements[0].getMethodName());
        p(stackTraceElements[0].getFileName());

        /*for(int i=0;i<stackTraceElements.length;i++){
            p(stackTraceElements[i].getClassName());
            p(stackTraceElements[i].getLineNumber());
            p(stackTraceElements[i].getMethodName());
            p(stackTraceElements[i].getFileName());
        }*/
    }

}
