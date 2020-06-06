package com.stevenyin.to

class ToDemo

fun main() {
    val (number1, name1) = 1 to "one"
    val (number2, name2) = Pair(2, "two")
    println("number1 = $number1, name1 = $name1")
    println("number2 = $number2, name2 = $name2")

	// Pair是Kotlin标准库中的类,用来表示一对元素
	infix fun Any.ooo(other: Any) = Pair(this, other)
    println(1 ooo 2)
    for ((key, value) in mapOf(1 ooo 2, 2 ooo 3, 3 ooo 4)) {
    	println("key = $key, value = $value")
    }
}

