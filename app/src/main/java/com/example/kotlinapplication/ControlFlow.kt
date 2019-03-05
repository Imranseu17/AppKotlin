package com.example.kotlinapplication

fun main() {
    var age = 60

    when(age){

        in 1..17-> println("Not eligible for voting")
        in 18..60->{
            println("Eligible  for voting")
            println("Not a senior citizen")
        }
        else->{
            println("Eligible  for voting")
        println("Is a senior citizen")
        }
    }

//    if(age <= 18) println("Not eligible for voting")
//    else if(age <= 60){
//        println("Eligible  for voting")
//        println("Not a senior citizen")
//    }
//    else{
//        println("Eligible  for voting")
//        println("Is a senior citizen")
//    }

}