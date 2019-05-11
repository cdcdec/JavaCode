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



