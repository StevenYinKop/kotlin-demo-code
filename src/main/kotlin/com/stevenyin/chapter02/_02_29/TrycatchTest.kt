package com.stevenyin.chapter02._02_29

import java.io.BufferedReader
import java.io.StringReader

class TrycatchTest
// 把try当做表达式使用
fun readNumber(reader: BufferedReader) =
	try {
		Integer.parseInt(reader.readLine())
	} catch (e: NumberFormatException) {
		null
	}

fun main(args: Array<String>) {
	val reader = BufferedReader(StringReader("123"))
	println(readNumber(reader))
}