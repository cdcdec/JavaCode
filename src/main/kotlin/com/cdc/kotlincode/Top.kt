package com.cdc.kotlincode

//位于一个kt文件中的，不依附于任何一个类的函数   顶层函数.可以在其它地方直接使用
fun p(any:Any?){
    println(any)
}

//Kotlin中通过使用顶层函数和顶层属性帮助我们消除了Java中常见的静态工具类，使我们的代码更加整洁


//位于一个kt文件中的，不依附于任何一个类的属性   顶层属性.可以在其它地方直接使用
//const 修饰符标记为 编译期常量.
// 位于顶层或者是 object 声明 或 companion object 的一个成员
//以 String 或原生类型值初始化
//没有自定义 getter
const val URL="http://www.baidu.com"


//fun main(args: Array<String>) {
//    p("========kkkkkk=======")
//}