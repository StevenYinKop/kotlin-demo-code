package com.stevenyin.chapter03._03_04

fun <T> Collection<T>.joinToString(
		separator: String = "; ",
		prefix: String = "",
		postfix: String = ""
): String {
	val result = StringBuilder(prefix)
	for((index, element) in this.withIndex()) {
		if (index > 0) result.append(separator)
		result.append(element)
	}
	result.append(postfix)
	return result.toString()
}

fun main(args: Array<String>) {
	println(listOf(1,2,3,4,5,6).joinToString())
}