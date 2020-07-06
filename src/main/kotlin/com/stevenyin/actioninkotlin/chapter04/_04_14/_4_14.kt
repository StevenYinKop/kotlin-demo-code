package com.stevenyin.actioninkotlin.chapter04._04_14

interface User {
	val username: String
}

class PrivateUser(override val username: String): User

class SubscribingUser(val email: String): User {
	override val username: String
		get() = email.substringBefore("@") //这个方法会在每次getUsername时候被调用
}
class FacebookUser(val account: String): User {
	override val username: String = queryUsernameByAccount(account) // 这个方法只会在该类实例化的时候被调用一次, 这样的话减少不必要的请求(网络请求或数据库等阻塞性请求)
}

fun queryUsernameByAccount(account: String): String = "$account DEMO"