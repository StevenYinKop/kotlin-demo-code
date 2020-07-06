package com.stevenyin.actioninkotlin.chapter03._03_09

fun parsePath(path: String) {
	val directory = path.substringBeforeLast("/")
	val fullName = path.substringAfterLast("/")
	
	val fileName = fullName.substringBeforeLast(".")
	val extension = path.substringAfterLast(".")
	
	println("Dir: $directory, name: $fileName, ext: $extension")
}
fun main(args: Array<String>) {
	parsePath("/Users/yole/kotlin-book/chapter.adoc")
}
