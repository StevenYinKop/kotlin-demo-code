package com.stevenyin.chapter03._03_08

// 声明一个可变的扩展属性
var StringBuilder.lastChar: Char
	get() = get(length - 1)
	set(value: Char) = setCharAt(length - 1, value)

fun main(args: Array<String>) {
	val sb = StringBuilder("Kotlin")
	println(sb.lastChar)
	sb.lastChar = 'l'
	println(sb.toString())
}
