package com.cdc.okhttp
data class User(
    var name:String,
    var age:Int,
    var area:String
)

data class User3 @JvmOverloads constructor(
    var name:String,
    var age:Int=10,
    var area:String="lh"
)

data class User2 @JvmOverloads constructor(
    var name:String="c",
    var age:Int=10,
    var area:String="lh"
)

data class Student(
    val name : String,
    val surname : String = "",
    val age : Int = 0
)