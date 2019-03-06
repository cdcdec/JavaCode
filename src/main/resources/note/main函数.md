# main函数

## 1.写在class外面
作为一个kt文件的顶层函数(位于一个kt文件中的，不依附于任何一个类的函数)存在.
```
class Test{

}
/** 我是main入口函数 **/
fun main(args: Array<String>) {
    var test=Test();
}

```

## 2.写在class里面
```
class Test{
    companion object {
    /** 我是main入口函数 **/
        @JvmStatic  //必须有这个注解
        fun main(args: Array<String>) {
           var test=Test();
        }
    }
}

```


