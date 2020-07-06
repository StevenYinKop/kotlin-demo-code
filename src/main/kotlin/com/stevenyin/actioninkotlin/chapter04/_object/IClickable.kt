package com.stevenyin.actioninkotlin.chapter04._object

interface IClickable {
	fun click()
	fun showOff() = println("This is IClickable.showOff() method, default implement")
}