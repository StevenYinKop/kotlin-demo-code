package cc.stevenyin.actioninkotlin.chapter02._02_28

import java.io.BufferedReader
import java.io.StringReader

class TrycatchTest
// 把try当做表达式使用
fun readNumber(reader: BufferedReader) {
	val number = try {
		Integer.parseInt(reader.readLine())
	} catch (e: NumberFormatException) {
		return
	}
	println(number)
}

fun main(args: Array<String>) {
	val reader = BufferedReader(StringReader("123"))
	println(readNumber(reader))
}