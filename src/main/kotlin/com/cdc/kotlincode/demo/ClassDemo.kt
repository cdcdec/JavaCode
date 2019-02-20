package com.cdc.kotlincode.demo
//这个类具有open属性，可以被其他类继承
open class ClassDemo{
    //被open修饰的方法,可以被子类继承和覆写
    open fun m1(){
        println("open 方法1")
    }
    //此方法默认被final修饰,不能被继承和覆写
    fun m2(){
        println("默认方法2")
    }
    open fun m3(){
        println("open 方法3")
    }
}
open class C2 : ClassDemo(){
    //覆写父类的方法必须加上override,且在fun的前面,
     override fun m1(){
        println("open 方法1 子类")
        m2()
    }

    //final修饰一个原本具有open属性的方法，使其变得不可再被覆写
    final override fun m3(){
        println("final修饰一个原本具有open属性的方法，使其变得不可再被覆写")
    }

}







fun main(args: Array<String>) {
var c2=C2()
    c2.m1()







}


