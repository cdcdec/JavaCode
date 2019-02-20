# open关键字 abstract关键字

在Kotlin中，所有的类,方法默认都是final的。
如果你需要允许它可以被继承，那么你需要使用open声明。
另外需要给每一个可以被重写的属性或者方法添加open修饰符。

```
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
```

abstract修饰的类不能被实例化,抽象类中抽象成员始终是open的，所以不需要显示的使用open修饰符.

