package com.stevenyin.actioninkotlin.chapter04._04_03

interface Clickable {
	// 普通的方法声明
	fun click()
	// 带默认实现的方法
	fun showOff() = println("This is IClickable.showOff() method, default implement")
}