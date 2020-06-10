package com.stevenyin.chapter03.stringandregex

import java.lang.IllegalStateException

class StringDemo

fun parsePath1(path: String): Triple<String, String, String> {
	val (directory, fullname) = path.substringBeforeLast("/") to path.substringAfterLast("/")
	val (filename, extension) = fullname.substringBeforeLast(".") to fullname.substringAfterLast(".")
	return Triple(directory, filename, extension)
}
fun parsePath2(path: String): Triple<String, String, String> {
	val regex = """(.+)/(.*)\.(.+)""".toRegex()
	val result = regex.matchEntire(path)
	println(result)
	if (result != null) {
		val (directory, filename, extension) = result.destructured
		return Triple(directory, filename, extension)
	}
	throw IllegalStateException("error!")
}

fun printResult(testString: String, directory: String, filename: String, extension: String) = println("testString = $testString, \ndirectory = $directory, \nfilename=$filename, \nextension=$extension")

fun main () {
	println("12.345-6.A".split("\\.|-".toRegex()))
	println("12.345-6.A".split(".", "-"))
	println("12.345-6.A".split('.', '-'))
    val testString = "/Users/stevenyin/kotlin-book/chapter.md"
    val (directory1, filename1, extension1) = parsePath1(testString)
	printResult(testString, directory = directory1, filename = filename1, extension = extension1)
    val (directory2, filename2, extension2) = parsePath2(testString)
	printResult(testString, directory = directory2, filename = filename2, extension = extension2)
}
