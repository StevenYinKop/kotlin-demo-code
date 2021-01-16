package com.stevenyin.data_structure.chapter02

import com.stevenyin.data_structure.api.AbstractList
import com.stevenyin.data_structure.model.Node

class CircularSingleLinked<E>: AbstractList<E> {
    private var first: Node<E>? = null
    constructor(): super()
    override fun add(e: E, index: Int) {
        TODO()
    }

    override fun get(index: Int): E {
        TODO()
    }

    override fun set(index: Int, e: E) {
        TODO()
    }

    override fun findIndex(e: E): Int {
        TODO()
    }

    override fun del(index: Int): E {
        TODO()
    }

//    private fun findNode(index: Int): Node<E> {
//        checkIfOutOfBound(index)
//        var node = first
//        for (i in 0 until index) {
//            node = node.next as Node<E>
//        }
//        return node as Node<E>
//    }
}