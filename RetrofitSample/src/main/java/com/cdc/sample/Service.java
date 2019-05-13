package com.cdc.sample;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface Service {
    @GET("/")
    Call<String> getString();
    @GET("/") Call<ResponseBody> getBody();
    @GET("/") @Streaming
    Call<ResponseBody> getStreamingBody();
    @POST("/") Call<String> postString(@Body String body);
    @POST("/{a}") Call<String> postRequestBody(@Path("a") Object a);
}
