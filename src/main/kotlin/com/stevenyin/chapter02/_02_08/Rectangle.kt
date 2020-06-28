package com.stevenyin.chapter02._02_08

import java.util.Random

class Rectangle (val height: Int, val width: Int) {
	val isSquare: Boolean
		get() {
			return height == width
		}
}
fun createRandomRectangle(): Rectangle {
	val random = Random();
	return Rectangle(random.nextInt(5), random.nextInt(5))
}
