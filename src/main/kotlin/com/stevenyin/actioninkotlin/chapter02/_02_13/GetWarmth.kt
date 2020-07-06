package com.stevenyin.actioninkotlin.chapter02._02_13

import com.stevenyin.actioninkotlin.chapter02._02_11.Color

class GetWarmth
	// 在when的分支合并多个选项
fun getWarmth(color: Color) = when (color) {
	Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
	Color.GREEN -> "neutral"
	Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun main(args: Array<String>) {
	println(getWarmth(Color.ORANGE))
	println(getWarmth(Color.GREEN))
	println(getWarmth(Color.YELLOW))
	println(getWarmth(Color.VIOLET))
	println(getWarmth(Color.INDIGO))
	println(getWarmth(Color.RED))
}