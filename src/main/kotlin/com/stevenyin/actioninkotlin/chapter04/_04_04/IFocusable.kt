package com.stevenyin.actioninkotlin.chapter04._04_04

// 定义一个实现了同样方法(showOff)的接口
interface Focusable {
	fun setFocus(b: Boolean) =
		println("I ${if (b) "get" else "lost"} focus.")
	fun showOff() = println("This is IFocusable.showOff() method, default implement")
}