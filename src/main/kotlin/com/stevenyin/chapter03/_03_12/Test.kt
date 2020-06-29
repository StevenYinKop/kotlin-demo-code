package com.stevenyin.chapter03._03_12

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
	// 提取局部函数来验证所有字段
	fun validate(user: User, value: String, fieldName: String) {
		if (value.isEmpty()) {
			throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
		}
	}
	validate(user, user.name, "Name")
	validate(user, user.address, "Address")
	TODO()
}

fun main(args: Array<String>) {
	saveUser(User(1, "", ""))
}
