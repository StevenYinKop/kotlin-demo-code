package com.stevenyin.enums

import com.stevenyin.bean.createRandomRectangle

class Main
fun main() {
	println("Hello World!")
	for (i in 1..100) {
		println(createRandomRectangle().isSquare)
	}
}
