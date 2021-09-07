package cc.stevenyin.actioninkotlin.chapter02._02_23

import cc.stevenyin.actioninkotlin.chapter02._02_22.fizzBuzz

class Loop
fun main(args: Array<String>) {
	for (i in 100 downTo 1 step 2) {
		print(fizzBuzz(i))
	}
}
