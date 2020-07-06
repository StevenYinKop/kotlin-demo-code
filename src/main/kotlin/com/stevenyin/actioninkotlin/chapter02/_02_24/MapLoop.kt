package com.stevenyin.actioninkotlin.chapter02._02_24

import java.util.TreeMap

class MapLoop

fun loopMap() {
	 // 使用TreeMap对键排序
	val binaryReps = TreeMap<Char, String>()
	 // 使用字符区间迭代从A到Z之间的字符
	for (c in 'A'..'F')
		// 把ASCII码转换成二进制, 并且存储到map中
		binaryReps[c] = Integer.toBinaryString(c.toInt())
	// 迭代map, 把键值付给两个变量并且打印出来
	for ((letter, binary) in binaryReps) {
		println("$letter = $binary")
	}
}
fun loopListWithIndex() {
	var list = arrayListOf("10", "11", "1001")
	for ((index, element) in list.withIndex()) {
		println("$index: $element")
	}
}

fun main(args: Array<String>) {
	loopMap()
	loopListWithIndex()
}