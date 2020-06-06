package com.stevenyin.loop

import java.util.TreeMap

class Loop {
	fun fizzBuzz(i: Int): String {
		val result = when {
			i % 15 == 0 -> "FizzBuzz"
			i % 3 == 0 -> "Fizz"
			i % 5 == 0 -> "Buzz"
			else -> "$i"
		}
		return result
	}
	fun loopMap() {
		val binaryReps = TreeMap<Char, String>()
		for (c in 'A'..'F')
			binaryReps[c] = Integer.toBinaryString(c.toInt())
		for ((letter, binary) in binaryReps) {
			println("$letter = $binary")
		}
	}
	fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
	fun isNotDigit(c: Char) = c !in '0'..'9'
}

fun main() {
	val loop = Loop()
	for (i in 1..100)
		println(loop.fizzBuzz(i))
	println("============================================")
	for (i in 100 downTo 1 step 2)
		println(loop.fizzBuzz(i))
	println("============================================")
	for (i in 0 until 100) // 等同于 for (i in 0..size - 1)
		println(loop.fizzBuzz(i))
	loop.loopMap()
	println(loop.isLetter('b'))
	println(loop.isLetter('1'))
	println(loop.isNotDigit('1'))
	println(loop.isNotDigit('b'))
}