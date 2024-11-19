package com.example.myapplication
fun main(){
    var data = mutableMapOf<String, String>(
        "hello" to "A type of greeting",
        "shyam" to "noun",
        "computer" to "An electronic device that takes input process it and gives output",
        "elephant"  to " A wild animal",
        "cow" to " A domestic animal"
    )
    println("Enter the word: ")
    var input : String = readln().lowercase()
    println(data[input])


}
