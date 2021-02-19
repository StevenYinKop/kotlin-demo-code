package com.stevenyin.data_structure.chapter02

import com.stevenyin.data_structure.api.AbstractList
import com.stevenyin.data_structure.model.Node
import java.util.concurrent.ThreadLocalRandom

class CircularSingleLinked<E>: AbstractList<E> {
    private var first: Node<E>? = null
    constructor(): super()
    override fun add(e: E, index: Int) {
        checkIfOutOfBound(index)
        val curNode: Node<E> = Node(e)
        if (index == 0) {
            if (size == 0) {
                first = curNode
                curNode.next = first
            } else {
                var lastNode = findNode(size - 1)
                lastNode.next = curNode
                curNode.next = first
                first = curNode
            }
        } else {
            var preNode = findNode(index - 1)
            curNode.next = preNode.next
            preNode.next = curNode
        }
        size++
        println(toString())
    }

    override fun get(index: Int): E {
        checkIfOutOfBound(index)
        return findNode(index).value
    }

    override fun set(index: Int, e: E) {
        checkIfOutOfBound(index)
        findNode(index).value = e
    }

    override fun findIndex(e: E): Int {
        var node = first
        var index = 0
        while (node != null) {
            if (node.value == e) {
                return index
            }
            node = node.next as Node<E>
            index++
        }
        return -1
    }

    override fun del(index: Int): E {
        checkIfOutOfBound(index)
        val preNode = findNode(if (index == 0) size - 1 else index - 1)
        val curNode = preNode.next
        preNode.next = curNode?.next
        if (index == 0) {
            first = preNode.next as Node<E>?
        }
        size --
        println(toString())
        return curNode!!.value
    }
    private fun findNode(index: Int): Node<E> {
        checkIfOutOfBound(index)
        var node = first as Node<E>
        for (i in 0 until index) {
            node = node.next as Node<E>
        }
        return node
    }
    override fun toString(): String {
        var node = first as Node<E>
        val sb = StringBuilder("CircularSingleLinked: [")
        val lastIndex: Int
        val firstIndex: Int = sb.length
        for (i in 0 until size) {
            sb.append("${node.value}")
            sb.append(if (i == size - 1) "" else " -> ")
            node = node.next as Node<E>
        }
        sb.append("]\n")
        lastIndex = sb.length
        for (i in 0 .. lastIndex - 2) {
            sb.append(if (i == firstIndex) "^" else if (i == lastIndex - 2) "|" else " ")
        }
        sb.append("\n")
        for (i in 0 until lastIndex - 1) {
            sb.append(if (i < firstIndex) " " else if (i == firstIndex) "|" else "-")
        }
        return sb.toString()
    }
}
fun main(){
    var linked = CircularSingleLinked<Int>()
    linked.addFirst(11) // 11
    linked.addLast(22) // 11 -> 22
    linked.addLast(33) // 11 -> 22 -> 33
    linked.addFirst(44) // 44 -> 11 -> 22 -> 33
    linked.add(55, 1) // 44 -> 55 -> 11 -> 22 -> 33
    linked.add(66, linked.size) // 44 -> 55 -> 11 -> 22 -> 33 -> 66
    linked.add(77, linked.size / 2) // 44 -> 55 -> 11 -> 77 -> 22 -> 33 -> 66
    linked.addFirst(88) // 88 -> 44 -> 55 -> 11 -> 77 -> 22 -> 33 -> 66
    while(!linked.isEmpty()) {
        val index = ThreadLocalRandom.current().nextInt(0, linked.size)
        print("删除索引为$index 的元素:  \n")
        linked.del(index)
    }
}