package com.stevenyin.data_structure.api

interface List<E> {
	fun add(e: E, index: Int)
	fun get(index: Int): E
	fun set(index: Int, e: E)
	fun contains(e: E): Boolean
	fun findIndex(e: E): Int
	fun del(index: Int): E
	fun delFirst(): E
	fun delLast(): E
	fun delElement(e: E): Boolean
	fun isEmpty(): Boolean
	fun addLast(e: E)
	fun addFirst(e: E)
}