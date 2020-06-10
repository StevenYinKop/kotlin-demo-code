package com.stevenyin.chapter03.override

class Main

// 扩展函数不能重写, 扩展函数在Java中会被编译成静态函数, 同时接收值将会作为第一个参数
fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")
var View.lastChar: Char
	get() = name.last()
	set(v: Char) {
		this.name = StringBuilder(name).setCharAt(name.length - 1, v).toString()
	}

fun main() {
	val view: View = Button("Button1")
	view.click()
	view.showOff()
	val button: Button = Button("Button2")
	button.showOff()
	view.lastChar = 'B'
	println(view.lastChar)
	println(button.lastChar)
	println(view.name)
	println(button.name)
}
