# google gson

> https://github.com/google/gson

## 序列化

将java 对象转成json


## 反序列化

将json转成java 对象

```
String json = "[\n"
                + "  // this is a comment\n"
                + "  \"a\",\n"
                + "  /* this is another comment */\n"
                + "  \"b\",\n"
                + "  # this is yet another comment\n"
                + "  \"c\"\n"
                + "]";

String json1="['a','b','c']";
//将json字符串转成List<String> 对象
List<String> abc = new Gson().fromJson(json1, new TypeToken<List<String>>() {}.getType());




```


## InetAddress类与json互转
```
Gson gson=new Gson();
InetAddress address = InetAddress.getByName("8.8.8.8");
String jsonAddress = gson.toJson(address);
//"8.8.8.8"
System.out.println(jsonAddress);
InetAddress value = gson.fromJson(jsonAddress, InetAddress.class);
//8.8.8.8==google-public-dns-a.google.com=google-public-dns-a.google.com
System.out.println(value.getHostAddress()+"=="+value.getCanonicalHostName()+"="+value.getHostName());

```

## SerializedName注解
```
class  A{
    //表明字段f在被反序列化时,将使用fooBar作为json的一个键值
    @SerializedName("fooBar")
    public final int f;
    //表明字段g在被反序列化时,将使用Another Foo作为json的一个键值
    @SerializedName("Another Foo")
    public final int g;

    public A() {
        this(1, 4);
    }
    public A(int f, int g) {
        this.f = f;
        this.g = g;
    }
}

GsonBuilder builder=new GsonBuilder();
Gson gson = builder.create();
String json='{' + "\"fooBar\":" + 5 + ",\"Another Foo\":" + 7 + '}';
A actual = gson.fromJson(json, A.class);

```
## @Expose注解
```
import com.google.gson.annotations.Expose;
public class MockObject{
//其自身包含两个属性deserialize(反序列化)和serialize（序列化），默认都为true。
@Expose//可以序列化  也可以反序列化
public  int exposedField = 1;
@Expose(serialize=true, deserialize=true)//可以序列化  也可以反序列化
public  int explicitlyExposedField = 12;
@Expose(serialize=false, deserialize=false)//不可以序列化  也不可以反序列化
public  int explicitlyHiddenField = 2;
@Expose(serialize=true, deserialize=false)//可以序列化  不可以反序列化
public  int explicitlyDifferentModeField = 21;
public  int hiddenField = 22;//不可以序列化  也不可以反序列化
}

Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//{"exposedField":0,"explicitlyExposedField":0,"explicitlyDifferentModeField":0}
p(gson.toJson(new MockObject()));

Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
String s="{\"exposedField\":11,\"explicitlyExposedField\":112,\"explicitlyHiddenField\":3,\"explicitlyDifferentModeField\":31,\"hiddenField\":32}";
MockObject mockObject=gson.fromJson(s,MockObject.class);
p(mockObject.exposedField);//11
p(mockObject.explicitlyExposedField);//112
p(mockObject.explicitlyHiddenField);//2  默认值，字符串中的3被忽略掉了
p(mockObject.explicitlyDifferentModeField);//21  默认值，字符串中的31被忽略掉了
p(mockObject.hiddenField);//22  默认值，字符串中的32被忽略掉了

```

## Map<String,String>转json  有类型序列化
```
Map<String, String> myMap = new HashMap<>();
String key = "key1";
myMap.put(key, "value1");
myMap.put("key2", "value2");
myMap.put("key3", "value3");
myMap.put("key4", "value4");

Type mapType = new TypeToken<Map<String, String>>() { }.getType();
Gson gson = new Gson();
JsonElement element = gson.toJsonTree(myMap, mapType);
if(element.isJsonObject()){
    JsonObject mapJsonObject = element.getAsJsonObject();
    //{"key1":"value1","key2":"value2","key3":"value3","key4":"value4"}
    p(mapJsonObject.toString());
    //true
    p(mapJsonObject.has(key));
}
```

## Map<String,String>转json  无类型序列化
```
Map<String, String> myMap = new HashMap<>();
String key = "key1";
myMap.put(key, "value1");
myMap.put("key2", "value2");
myMap.put("key3", "value3");
myMap.put("key4", "value4");
Gson gson = new Gson();
JsonElement element = gson.toJsonTree(myMap, myMap.getClass());
if(element.isJsonObject()){
    JsonObject mapJsonObject = element.getAsJsonObject();
    //{"key1":"value1","key2":"value2","key3":"value3","key4":"value4"}
    p(mapJsonObject.toString());
    //true
    p(mapJsonObject.has(key));
}
```








