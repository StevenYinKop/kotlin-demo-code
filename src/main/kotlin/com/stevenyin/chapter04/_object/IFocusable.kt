package com.stevenyin.chapter04._object

interface IFocusable {
	fun setFocus(b: Boolean) =
		println("I ${if (b) "get" else "lost"} focus.")
	fun showOff() = println("This is IFocusable.showOff() method, default implement")
}