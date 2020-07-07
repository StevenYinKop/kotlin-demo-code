package com.stevenyin.actioninkotlin.chapter04._04_15

// 在setter中访问支撑字段
class User(val name: String) {
	
	var address: String= "unspecified"
		set(value: String) {
			println("""
					Address was changed for $name:
					"$field" -> "$value".""".trimIndent())
				field = value
		}
}

fun main(args: Array<String>) {
	val user = User("Alice")
	user.address = "Elsenheimerstrasse 47, 80687 Muenchen"
}
