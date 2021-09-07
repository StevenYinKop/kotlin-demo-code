package cc.stevenyin.data_structure.api

interface Stack<E> {
	fun push(e: E)
	fun pop(): E
	fun peek(): E
	fun getSize(): Int
	fun isEmpty(): Boolean
}