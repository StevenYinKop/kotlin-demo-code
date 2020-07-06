package com.stevenyin.data_structure.chapter02

import com.stevenyin.data_structure.api.List
import kotlin.Array as Arr
import java.lang.IllegalArgumentException
import com.stevenyin.data_structure.model.Person

class Array<E>: List<E> {
	private var size = 0
	private var array: Arr<Any?>
	constructor(): this(10)
	constructor (capacity: Int){
		this.array = arrayOfNulls(capacity)
	}
	override fun getSize() = this.size
	override fun add(e: E, index: Int) {
		if (index < 0 || index > this.size) throw IllegalArgumentException("Invalid index: $index!")
		if (this.array.size == this.size) {
			this.resize(size * 2)
		}
		for (i in size - 1 downTo index) {
			array[i + 1] = array[i]
		}
		this.array[index] = e
	    this.size++
	}
	override fun get(index: Int): E {
		if (index < 0 || index > this.size) throw IllegalArgumentException("Invalid index: $index!")
		return this.array[index] as E
	}

	override fun set(index: Int, e: E) {
		if (index < 0 || index > this.size) throw IllegalArgumentException("Invalid index: $index!")
		this.array[index] = e
	}
	override fun contains(e: E) = find(e) != -1
	override fun find(e: E): Int {
		for(i in 0 until this.size) {
			if (this.array[i] == e) {
				return i
			}
		}
		return -1
	}
	override fun del(index: Int): E {
		if (index < 0 || index >= this.size) throw IllegalArgumentException("Invalid index: $index!")
		val ret = this.array[index] as E
		for(i in index + 1 until this.size) {
			this.array[i - 1] = this.array[i]
		}
		this.array[size] = null
		this.size --
		if (this.size < this.array.size / 2) {
			this.resize(this.array.size / 2)
		}
		return ret
	}
	override fun delFirst() = del(0)
	override fun delLast() = del(this.size - 1)
	override fun delElement(e: E): Boolean {
		val index = find(e)
		if (index != -1) {
			del(index)
			return true
		} else {
			return false
		}
	}
	override fun isEmpty() = size == 0
	override fun addLast(e: E) = add(e, size)
	override fun addFirst(e: E) = add(e, 0)
	override fun toString(): String {
		val sb = StringBuilder("Array: size=$size, capacity=${this.array.size}, [")
		for (i in 0 until size) {
			sb.append("${this.array[i]}")
			if (i != size - 1) {
				sb.append(", ")
			}
		}
		return sb.append("]").toString()
	}
	fun getCapacity() = array.size
	private fun resize(capacity: Int) {
		val newArray = arrayOfNulls<Any?>(capacity)
		for (i in 0 until size) newArray[i] = array[i]
		this.array = newArray
	}
}

fun main(){
	var arr = Array<Person>()
	for (i in 0..10) arr.addFirst(Person("Steven$i", i))
	println(arr.toString())
	for (i in 0..10) arr.delFirst()
	println(arr.toString())
}
