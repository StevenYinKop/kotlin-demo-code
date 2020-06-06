package com.stevenyin.override

open class View(open var name: String) {
	open fun click() = println("View clicked! name=$name")
}