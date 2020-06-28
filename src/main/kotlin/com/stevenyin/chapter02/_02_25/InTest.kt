package com.stevenyin.chapter02._02_25

class InTest
// 使用in检查区间成员
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z' // 实际上等同于'a' <= c && 'z' >= c
fun isNotDigit(c: Char) = c !in '0'..'9'

fun main(args: Array<String>) {
	println(isLetter('q'))
	println(isNotDigit('x'))
}
