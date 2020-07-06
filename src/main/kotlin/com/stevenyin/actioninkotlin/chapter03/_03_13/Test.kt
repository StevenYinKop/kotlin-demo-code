package com.stevenyin.actioninkotlin.chapter03._03_13

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
	// 提取局部函数来验证所有字段
	fun validate(value: String, fieldName: String) {
		if (value.isEmpty()) {
			throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
		}
	}
	validate(user.name, "Name")
	validate(user.address, "Address")
	TODO()
}