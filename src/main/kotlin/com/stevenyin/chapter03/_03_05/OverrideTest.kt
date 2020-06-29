package com.stevenyin.chapter03._03_05
class Button() : View() {
	override fun click() = println("Button clicked!")
}
open class View() {
	open fun click() = println("View clicked!")
}

fun main(args: Array<String>) {
	val view: View = Button()
	view.click()
}