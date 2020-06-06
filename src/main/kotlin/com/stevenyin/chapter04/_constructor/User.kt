package com.stevenyin.chapter04._constructor

class User(val nickname: String)
class User2 constructor(nickname: String) {
	val nickname: String
	init {
		this.nickname = nickname
	}
}
class User3 constructor(nickname: String) {
	val nickname = nickname
}

class Secretive private constructor() {}