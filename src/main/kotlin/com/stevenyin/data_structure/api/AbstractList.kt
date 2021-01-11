package com.stevenyin.data_structure.api

abstract class AbstractList<E>: List<E> {
    protected var size: Int = 0
    override fun delLast() = del(this.size - 1)
    override fun isEmpty() = size == 0
    override fun addLast(e: E) = add(e, size)
    override fun contains(e: E) = findIndex(e) != -1
    override fun delFirst() = del(0)
    override fun delElement(e: E): Boolean {
        val index = findIndex(e)
        if (index != -1) {
            del(index)
            return true
        } else {
            return false
        }
    }
    override fun addFirst(e: E) = add(e, 0)
    fun checkIfOutOfBound(index: Int, withBound: Boolean = false) {
        if (withBound) {
            if (index < 0 || index >= size) throw IllegalArgumentException("Invalid index: $index!")
        } else {
            if (index < 0 || index > size) throw IllegalArgumentException("Invalid index: $index!")
        }
    }
}