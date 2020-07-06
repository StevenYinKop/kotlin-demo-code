package com.stevenyin.actioninkotlin.chapter03._03_06

import com.stevenyin.actioninkotlin.chapter03._03_05.View
import com.stevenyin.actioninkotlin.chapter03._03_05.Button

fun View.showOff() = println("I'm a View!")
fun Button.showOff() = println("I'm a Button!")

fun main(args: Array<String>) {
	val view: View = Button()
	view.showOff()
}
