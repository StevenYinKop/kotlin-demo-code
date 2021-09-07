package cc.stevenyin.actioninkotlin.chapter02._02_26

class InTest

fun recognize(c: Char) = when(c) {
	in '0'..'9' -> "It's a digit!"
	in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
	else -> "I donno!"
}

fun main(args: Array<String>) {
	println(recognize('a'))
	println(recognize('2'))
	println(recognize('%'))
}