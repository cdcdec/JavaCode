OkHttp
======

## EventListener
```
RecordingEventListener继承EventListener
OkHttpClient.Builder builder = new OkHttpClient.Builder();
builder.eventListener(new RecordingEventListener());

```

一个成功的post请求(没有上传文件),会按照一下的顺序调用EventListener中的方法:
callStart-->dnsStart-->dnsEnd-->connectStart-->connectEnd-->connectionAcquired-->requestHeadersStart
-->requestHeadersEnd-->requestBodyStart-->requestBodyEnd-->responseHeadersStart-->responseHeadersEnd
-->responseBodyStart-->responseBodyEnd-->connectionReleased-->callEnd


## MockWebServer
```
MockWebServer server = new MockWebServer();
server.enqueue(new MockResponse().setBody("abc"));
 Request request = new Request.Builder()
                .url(server.url("/"))  //这里的path只能用/
                .build();
Call call = new OkHttpClient.Builder().build().newCall(request);
try {
    Response response=call.execute();
    LogUtil.w(response.body().string());//输出abc
    } catch (IOException e){
            e.printStackTrace();
    }
```

## post上传参数  键值对

```
 public void  postJsonStr(Callback callback){
    //要上传的参数
    RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), "{\"username\":\"admin\";\"password\":\"admin\"}");
    server.enqueue(new MockResponse()
                    .setResponseCode(200)
                    .setBody("{\"username\":\"admin\";\"password\":\"admin\",\"type\":1}"));
            Request request = new Request.Builder()
            .post(requestBody)
            .url(server.url("/"))
            .build();
    Call call = getHttpClient().newCall(request);
    call.enqueue(callback);
   }
```

## post上传字符串
```
 public void  postJsonStr(Callback callback){
    //上传的字符串
    RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), "{\"username\":\"admin\";\"password\":\"admin\"}");
    server.enqueue(new MockResponse()
                    .setResponseCode(200)
                    //返回的字符串
                    .setBody("{\"username\":\"admin\";\"password\":\"admin\",\"type\":1}"));
            Request request = new Request.Builder()
            .post(requestBody)
            .url(server.url("/"))
            .build();
    Call call = getHttpClient().newCall(request);
    call.enqueue(callback);
    }

```













