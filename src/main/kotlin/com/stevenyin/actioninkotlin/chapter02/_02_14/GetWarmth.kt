package com.stevenyin.actioninkotlin.chapter02._02_14

import com.stevenyin.actioninkotlin.chapter02._02_11.Color.*
import com.stevenyin.actioninkotlin.chapter02._02_11.Color

class GetWarmth
	// 在when的分支合并多个选项
fun getWarmth(color: Color) = when (color) {
	RED, ORANGE, YELLOW -> "warm"
	GREEN -> "neutral"
	BLUE, INDIGO, VIOLET -> "cold"
}

fun main(args: Array<String>) {
	println(getWarmth(ORANGE))
	println(getWarmth(GREEN))
	println(getWarmth(YELLOW))
	println(getWarmth(VIOLET))
	println(getWarmth(INDIGO))
	println(getWarmth(RED))
}