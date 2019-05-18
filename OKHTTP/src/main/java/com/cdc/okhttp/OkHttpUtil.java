package com.cdc.okhttp;

import okhttp3.*;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpUtil {

    public final MockWebServer server = new MockWebServer();
    public OkHttpClient getHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.eventListener(new RecordingEventListener());
        builder.connectTimeout(1L, TimeUnit.SECONDS);
        builder.callTimeout(1L, TimeUnit.SECONDS);
        OkHttpClient okHttpClient = builder.build();
        return okHttpClient;
    }

    public Request getRequest(String url) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        return request;
    }

    public void get(Callback callback, String url) {
        Call call = getHttpClient().newCall(getRequest(url));
        call.enqueue(callback);
    }


    public void post(Callback callback, String url) {
        //Form表单格式的参数传递
        FormBody formBody = new FormBody.Builder()
                .add("mobile", "18903958133")
                .add("code", "")
                .add("type", "1")
                .build();
        Request request = new Request.Builder()
                .post(formBody)
                .url(url)
                .build();
        Call call = getHttpClient().newCall(request);
        call.enqueue(callback);
    }


    private Request.Builder getRequestBuilder(String path, String... headers){
        Request.Builder builder = new Request.Builder();
        builder.url(path);
        for (int i = 0, size = headers.length; i < size; i += 2) {
            builder.addHeader(headers[i], headers[i + 1]);
        }
        return builder;
    }


    public void head(){
        server.enqueue(new MockResponse()
               .setResponseCode(200)
                .setBody("abc")
                .clearHeaders()
                .addHeader("content-type: text/plain")
                .addHeader("content-length", "3")

        );
        Request request = new Request.Builder()
                .url(server.url("/"))
                .build();
        Call call = getHttpClient().newCall(request);
        try {
            Response response=call.execute();
            LogUtil.w(response.body().string());
            LogUtil.w(response.header("content-type"));
            LogUtil.w(response.header("content-length"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }






}


