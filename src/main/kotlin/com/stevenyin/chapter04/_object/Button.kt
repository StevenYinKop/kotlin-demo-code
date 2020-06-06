package com.stevenyin.chapter04._object

class Button: IClickable, IFocusable{
	override fun showOff() {
		super<IFocusable>.showOff()
		super<IClickable>.showOff()
	}

	override fun click() = println("I'm Button, click~click~")
}

fun main() {
	Button().click();
	Button().showOff();
}