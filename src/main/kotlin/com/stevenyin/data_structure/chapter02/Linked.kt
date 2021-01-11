package com.stevenyin.data_structure.chapter02

import com.stevenyin.data_structure.api.AbstractList
import com.stevenyin.data_structure.model.Node
import com.stevenyin.data_structure.model.Person

class Linked<E>: AbstractList<E> {
    private var first: Node<E>? = null
    constructor() {}
    override fun add(e: E, index: Int) {
        val node: Node<E> = Node(e)
        if (index == 0) {
            node.next = first
            first = node
        } else {
            val preNode = findNode(index - 1)
            node.next = preNode.next
            preNode.next = node
        }
        size++
    }
    override fun get(index: Int) = findNode(index).value
    override fun set(index: Int, e: E) {
        findNode(index).value = e
    }

    override fun findIndex(e: E): Int {
        var node = first
        for (i in 0 until size) {
            if (e!!.equals(node!!.value)) return i
            node = node.next
        }
        return -1
    }

    override fun del(index: Int): E {
        var node = findNode(index)
        if (index == 0) {
            first = first!!.next
        } else {
            node.next = node.next!!.next
        }
        size --
        return node.value
    }
    
    private fun findNode(index: Int): Node<E> {
        checkIfOutOfBound(index)
        var node: Node<E>? = first
        for (i in 0 until index) {
            node = node!!.next
        }
        return node as Node
    }
    override fun toString(): String {
        var node = first
        val sb = StringBuffer("Linked[head]: ");
        while (node != null) {
            sb.append("${node.value} -> ")
            node = node.next
        }
        sb.append("NULL");
        return sb.toString()
    }
}
fun main(){
    var linked = Linked<Person>()
    println(linked.toString())
    for (i in 0..10) {
        linked.addFirst(Person("Steven$i", i))   
        println(linked.toString())
    }
//    for (i in 0..10) {
//        linked.addLast(Person("Steven$i", i))   
//        println(linked.toString())
//    }
    for (i in 0..10) {
        linked.delFirst()
        println(linked.toString())
    }
}