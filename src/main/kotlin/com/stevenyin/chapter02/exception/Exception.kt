package com.stevenyin.exception

import java.io.BufferedReader
import java.io.StringReader

class Exception {
	fun readNumber(reader: BufferedReader): Int? {
		try {
			return Integer.parseInt(reader.readLine())
		} catch (e: NumberFormatException) {
			return null
		} finally {
			reader.close()
		}
	}
	fun readNumber2(reader: BufferedReader) = 
		try {
			Integer.parseInt(reader.readLine())
		} catch (e: NumberFormatException) {
			null
		}
}
fun main () {
	println(Exception().readNumber(BufferedReader(StringReader("123"))))
	println(Exception().readNumber(BufferedReader(StringReader("123abc"))))
	println(Exception().readNumber(BufferedReader(StringReader("abc"))))
	println(Exception().readNumber2(BufferedReader(StringReader("123"))))
	println(Exception().readNumber2(BufferedReader(StringReader("123abc"))))
	println(Exception().readNumber2(BufferedReader(StringReader("abc"))))
}