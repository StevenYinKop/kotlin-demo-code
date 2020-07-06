package com.stevenyin.actioninkotlin.chapter04._04_16

class LengthCounter {
	var counter: Int = 0
			private set // 不能在外部对counter进行赋值
	fun addWord(word: String) {
		counter += word.length
	}
}
fun main(args: Array<String>) {
	val lengthCounter = LengthCounter()
	println(lengthCounter.counter)
	lengthCounter.addWord("Hi!")
	println(lengthCounter.counter)
//		counter = "wtf?" X
}