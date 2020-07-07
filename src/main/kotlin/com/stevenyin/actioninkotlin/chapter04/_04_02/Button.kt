package com.stevenyin.actioninkotlin.chapter04._04_02

import com.stevenyin.actioninkotlin.chapter04._04_01.Clickable

class Button: Clickable {
	override fun click() = println("I was clicked")
}

fun main(args: Array<String>) {
	Button().click()
}