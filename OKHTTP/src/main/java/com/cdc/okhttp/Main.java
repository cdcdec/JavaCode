package com.cdc.okhttp;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {

        OkHttpUtil okHttpUtil = new OkHttpUtil();
        okHttpUtil.postJsonStr(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Main.p(e.getLocalizedMessage() + "===" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res = response.body().string();
                RequestBody b=call.request().body();
                Main.p(b.contentType().toString());
            }
        });


    }

    public static void p(String str) {
        System.out.println(str);
    }
}
