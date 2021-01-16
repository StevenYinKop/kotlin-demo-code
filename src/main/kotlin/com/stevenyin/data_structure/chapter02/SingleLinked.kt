package com.stevenyin.data_structure.chapter02

import com.stevenyin.data_structure.api.AbstractList
import com.stevenyin.data_structure.model.Node
import com.stevenyin.data_structure.model.Person

class SingleLinked<E>: AbstractList<E> {
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
            node = node.next as Node
        }
        return -1
    }

    override fun del(index: Int): E {
        var res = first
        if (index == 0) {
            first = first!!.next as Node
        } else {
            var node = findNode(index - 1)
            res = node.next as Node
            node.next = res.next
        }
        size --
        return res!!.value
    }
    
    private fun findNode(index: Int): Node<E> {
        checkIfOutOfBound(index)
        var node = first
        for (i in 0 until index) {
            node = node!!.next as Node
        }
        return node as Node
    }
    override fun toString(): String {
        var node = first
        val sb = StringBuffer("Linked[head]: ");
        while (node != null) {
            sb.append("${node.value} -> ")
            node = node.next as Node
        }
        sb.append("NULL");
        return sb.toString()
    }
}
fun main(){
    var linked = SingleLinked<Person>()
    println(linked.toString())
    for (i in 0..10) {
        val p = Person("Steven$i", i)
        if (i % 2 == 0) {
            linked.addFirst(p)   
        } else {
            linked.addLast(p)
        }
        println(linked.toString())
    }
//    for (i in 0..10) {
//        linked.addLast(Person("Steven$i", i))   
//        println(linked.toString())
//    }
    for (i in 0..10) {
        if (i % 2 == 0) {
            linked.delFirst()  
        } else {
            linked.delLast()
        }
        println(linked.toString())
    }
}