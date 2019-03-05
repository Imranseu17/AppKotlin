package com.example.kotlinapplication

fun main() {

     var x = 10.0f
    PrintDataType(x)

    var A = 'a'
    var B = "Imran"

    PrintDataType(A)
    PrintDataType(B)

}

fun<T> PrintDataType(x:T){

    when(x){

        is Short ->println(x.toString() + " is an Short")
        is Int ->println(x.toString() + " is an Integer")
        is Long ->println(x.toString() + " is an Long")
        is Float ->println(x.toString() + " is an Float")
        is Double ->println(x.toString() + " is an Double")
        is Char ->println(x.toString() + " is an Character")
        is String ->println(x.toString() + " is an String")
        is Byte ->println(x.toString() + " is an Byte")
    }
}