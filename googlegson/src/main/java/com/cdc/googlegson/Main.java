package com.cdc.googlegson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.Excluder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Excluder excluder = Excluder.DEFAULT.excludeFieldsWithoutExposeAnnotation();

        Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String s="{\"exposedField\":11,\"explicitlyExposedField\":112,\"explicitlyHiddenField\":3,\"explicitlyDifferentModeField\":31,\"hiddenField\":32}";
        MockObject mockObject=gson.fromJson(s,MockObject.class);
        p(mockObject.exposedField);//11
        p(mockObject.explicitlyExposedField);//112
        p(mockObject.explicitlyHiddenField);//2  默认值，字符串中的3被忽略掉了
        p(mockObject.explicitlyDifferentModeField);//21  默认值，字符串中的31被忽略掉了
        p(mockObject.hiddenField);//22  默认值，字符串中的32被忽略掉了




      /*  //false
        boolean bl=excluder.excludeClass(MockObject.class, true);

        Field f = createFieldAttributes("hiddenField");
        //true
        p(excluder.excludeField(f, true));*/

    }

    private static Field createFieldAttributes(String fieldName) throws Exception {
        return MockObject.class.getField(fieldName);
    }

    public static void p(Object o){
        if(o instanceof Boolean){
            System.out.printf("result =%s\n",o.toString());
        }else{
            System.out.printf("result =%s\n",o);
        }

    }
}

/*class  A{
    //表明字段f在被反序列化时,将使用fooBar作为json的一个键值
    @Expose(serialize = false)
    public final int a;
    //表明字段g在被反序列化时,将使用Another Foo作为json的一个键值
    @Expose(deserialize = false)
    public final int b;

    public A() {
        this(1, 4);
    }
    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }
}*/
