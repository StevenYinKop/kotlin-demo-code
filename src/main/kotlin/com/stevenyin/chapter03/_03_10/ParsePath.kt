package com.stevenyin.chapter03._03_10

fun parsePath(path: String) {
	val regex = """(.+)/(.+)\.(.+)""".toRegex()
	val matchResult = regex.matchEntire(path)
	if (matchResult != null) {
		val (directory, fileName, extension) = matchResult.destructured
		println("Dir: $directory, name: $fileName, ext: $extension")
	}
}