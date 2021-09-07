package cc.stevenyin.actioninkotlin.chapter02._02_02

class StringTemplate

fun main(args: Array<String>) {
	val name = if (args.size > 0) args[0] else "Kotlin"
	println("Hello, $name")
}