package com.stevenyin.actioninkotlin.chapter03._03_14

class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave() {
	// 提取局部函数来验证所有字段
	fun validate(value: String, fieldName: String) {
		if (value.isEmpty()) {
			throw IllegalArgumentException("Can't save user $id: empty $fieldName")
		}
	}
	validate(name, "Name")
	validate(address, "Address")
}
fun saveUser(user: User) {
	user.validateBeforeSave()
	TODO()
}
fun main(args: Array<String>) {
	saveUser(User(1, "1", "1"))
}