package cc.stevenyin.actioninkotlin.chapter04._04_05

import cc.stevenyin.actioninkotlin.chapter04._04_03.Clickable
import cc.stevenyin.actioninkotlin.chapter04._04_04.Focusable

class Button: Clickable, Focusable {
	override fun click() = println("I was clicked")
	//  如果同样的继承成员有不止一个实现, 必须提供一个显示实现
	//  使用<>加上父类型名字的super表明了你想要调用哪一个父类的方法
	override fun showOff() = super<Clickable>.showOff()
	//	Java中的语法是Clickable.super.showOff();
	//  super<Focusable>.showOff()
}

fun main(args: Array<String>) {
	val button = Button()
	button.showOff() // This is IClickable.showOff() method, default implement
	button.setFocus(true) // I get focus.
	button.setFocus(false) // I lost focus.
	button.click() // I was clicked
}