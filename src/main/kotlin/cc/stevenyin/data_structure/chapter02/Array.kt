package cc.stevenyin.data_structure.chapter02

import cc.stevenyin.data_structure.api.AbstractList
import cc.stevenyin.data_structure.model.Person
import kotlin.Array as Arr

class Array<E>: AbstractList<E> {
	private var array: Arr<Any?>
	constructor(): this(10)
	constructor (capacity: Int){
		this.array = arrayOfNulls(capacity)
	}
	override fun add(e: E, index: Int) {
        checkIfOutOfBound(index)
		if (this.array.size == this.size) {
			this.resize(size * 2)
		}
		for (i in size - 1 downTo index) {
			array[i + 1] = array[i]
		}
		this.array[index] = e
	    super.size++
	}
	override fun get(index: Int): E {
		checkIfOutOfBound(index)
		return this.array[index] as E
	}

	override fun set(index: Int, e: E) {
        checkIfOutOfBound(index)
		this.array[index] = e
	}
	override fun findIndex(e: E): Int {
		for(i in 0 until this.size) {
			if (this.array[i] == e) {
				return i
			}
		}
		return -1
	}
	override fun del(index: Int): E {
        checkIfOutOfBound(index, true)
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
