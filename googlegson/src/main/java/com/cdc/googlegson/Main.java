package com.cdc.googlegson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws UnknownHostException {


        GsonBuilder builder=new GsonBuilder();


        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String json='{' + "\"f\":" + 5 + ",\"g\":" + 7 + '}';
        A actual =new A(7,8);

        p(gson.toJson(actual));







    }

    public static void p(Object o){
        System.out.println(o);
    }
}

class  A{
    //表明字段f在被反序列化时,将使用fooBar作为json的一个键值
    @Expose(serialize = false)
    public final int a;
    //表明字段g在被反序列化时,将使用Another Foo作为json的一个键值
    @Expose(deserialize = false)
    public final int b;

    public A() {
        this(1, 4);
    }
    public A(int f, int g) {
        this.f = f;
        this.g = g;
    }
}
