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
    LogUtil.w(response.body().string());
    } catch (IOException e){
            e.printStackTrace();
    }
```






