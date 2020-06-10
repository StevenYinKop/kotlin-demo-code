@file:JvmName("CollectionsUtils")
package com.stevenyin.chapter02.collections

fun <T> jsonToString(
	collection: Collection<T>,
	separator: String = ", ",
	prefix: String = "[",
	postfix: String = "]"
): String {
	val result = StringBuilder(prefix)
	for ((index, element) in collection.withIndex()) {
		if (index > 0) result.append(separator)
		result.append(element)
	}
	result.append(postfix)
	return result.toString()
}
//fun <T> Collection<T>.jsonToString(
//	separator: String = ", ",
//	prefix: String = "[",
//	postfix: String = "]"
//): String {
//	val result = StringBuilder(prefix)
//	for ((index, element) in this.withIndex()) {
//		if (index > 0) result.append(separator)
//		result.append(element)
//	}
//	result.append(postfix)
//	return result.toString()
//}
fun String.lastChar(): Char {
	println(this)
	return this.get(this.length - 1);
}
fun main() {
	val set = hashSetOf(1, 7, 53)
	val list = arrayListOf(1, 7, 53)
	val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
	println(set.javaClass)
	println(list.javaClass)
	println(map.javaClass)

	val strings = listOf("first", "second", "fourteenth")
	println(strings)
	println(jsonToString(strings, separator = ";", prefix = "(", postfix = ")"))
	// 在调用jsonToString函数的时候, 传参顺序可以和函数声明不一致, 如果有这样的需求需要显示声明参数名称和行参对应
	println(jsonToString(strings, prefix = "「", separator = ";", postfix = "」"))
	// 如果需要省略其中的某些参数, 可以在函数定义的位置进行默认值的设置, 这时不传入的参数按照默认值进行计算
	println(jsonToString(strings, prefix = "{", postfix = "}"))
	println(strings.javaClass)
	println("Kotlin".lastChar())
}
