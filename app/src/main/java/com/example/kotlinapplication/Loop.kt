package com.example.kotlinapplication

fun main() {
    for(i in 0..10) println(i)
    println(".....................")
    var i = 0
    while (i <= 10){
        println(i)
        i += 2
    }
    println(".....................")
    var j = 0
    do{
        println(j)
        j += 5
    }while (j <= 100)
}