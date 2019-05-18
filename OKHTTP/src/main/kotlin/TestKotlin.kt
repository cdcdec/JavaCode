fun main(args: Array<String>) {
   var s="漯河市 漯河市丁家油坊"
    var a=s.length


var s2=s.trimIndent()
    var b=s2.length

    println("a=$a,sa=$s b=$b s2=$s2")
}

data class Student(
    val name : String,
    val surname : String = "",
    val age : Int = 0
)




data class User(
    var name:String,
    var age:Int,
    var area:String
)

data class User2 @JvmOverloads constructor(
    var name:String="c",
    var age:Int=10,
    var area:String="lh"
)

data class User3(
    var name:String,
    var age:Int=10,
    var area:String="lh"
)






