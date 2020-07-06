package com.stevenyin.actioninkotlin.chapter09

import java.lang.IllegalArgumentException
import java.util.Arrays

fun copy(from: Array<out Any>, to: Array<Any>) {
	if (from.size != to.size)
		throw IllegalArgumentException("error")
	for (i in from.indices) {
		to[i] = from[i]
	}
}

fun set(to: Array<in String>, index: Int, value: String) = {
	to[index] = value
}

fun main(args: Array<String>) {
	val from: Array<Int> = arrayOf(1, 2, 3, 4)
	val to: Array<Any> = Array<Any>(4, { "hello" + it })
	println(Arrays.toString(to));
	copy(from, to)
	println(Arrays.toString(to));
	set(to, 1, "5");
	println(Arrays.toString(to));
}