package com.stevenyin.chapter02._02_12

import com.stevenyin.chapter02._02_11.Color

class GetMnemonic
// 用when来处理枚举类型
fun getMnemonic(color: Color) = when (color) {
	Color.RED -> "Rechard"
	Color.ORANGE -> "Of"
	Color.YELLOW -> "York"
	Color.GREEN -> "Gave"
	Color.BLUE -> "Battle"
	Color.INDIGO -> "In"
	Color.VIOLET -> "Vain"
}

fun main(args: Array<String>) {
	println(getMnemonic(Color.BLUE))
}