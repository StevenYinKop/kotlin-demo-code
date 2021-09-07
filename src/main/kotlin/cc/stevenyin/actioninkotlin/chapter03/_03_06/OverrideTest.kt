package cc.stevenyin.actioninkotlin.chapter03._03_06

import cc.stevenyin.actioninkotlin.chapter03._03_05.Button
import cc.stevenyin.actioninkotlin.chapter03._03_05.View

fun View.showOff() = println("I'm a View!")
fun Button.showOff() = println("I'm a Button!")

fun main(args: Array<String>) {
	val view: View = Button()
	view.showOff()
}
