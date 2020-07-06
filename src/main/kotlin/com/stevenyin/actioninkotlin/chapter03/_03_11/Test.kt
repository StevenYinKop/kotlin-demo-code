package com.stevenyin.actioninkotlin.chapter03._03_11

import java.lang.IllegalArgumentException

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
	if (user.name.isEmpty()) {
		throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
	}
	if (user.address.isEmpty()) {
		throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
	}
	TODO()
}

fun main(args: Array<String>) {
	saveUser(User(1, "", ""))
}
