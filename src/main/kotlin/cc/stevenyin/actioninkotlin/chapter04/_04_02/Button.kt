package cc.stevenyin.actioninkotlin.chapter04._04_02

import cc.stevenyin.actioninkotlin.chapter04._04_01.Clickable

class Button : Clickable {
	override fun click() = println("I was clicked")
}

fun main(args: Array<String>) {
	Button().click()
}

open class A {
	open fun overrideTest(list: AbstractList<String>) {
		TODO()
	}
}

class B : A() {
	override fun overrideTest(list: AbstractList<String>) {
		TODO()
	}
}