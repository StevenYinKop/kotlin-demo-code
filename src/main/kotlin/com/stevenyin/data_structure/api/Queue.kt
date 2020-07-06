package com.stevenyin.data_structure.api

interface Queue<E> {
	fun enqueue(e: E)
	fun dequeue(): E
	fun getFront(): E
	fun getSize(): Int
	fun isEmpty(): Boolean
}