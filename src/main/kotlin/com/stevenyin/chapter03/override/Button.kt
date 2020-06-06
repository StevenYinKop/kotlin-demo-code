package com.stevenyin.override

class Button(override var name: String) : View(name) {
	override fun click() = println("Button clicked! name=$name")
}