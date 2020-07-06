package com.stevenyin.actioninkotlin.chapter03._03_07

// 声明一个扩展的不可变属性
val String.lastChar: Char
	get() = get(length - 1)
