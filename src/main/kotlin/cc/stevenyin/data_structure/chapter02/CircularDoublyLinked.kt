package cc.stevenyin.data_structure.chapter02

import cc.stevenyin.data_structure.api.AbstractList
import cc.stevenyin.data_structure.model.DoublyNode
import java.util.concurrent.ThreadLocalRandom

class CircularDoublyLinked<E>: AbstractList<E> {
    private var first: DoublyNode<E>? = null
    private var last: DoublyNode<E>? = null
    constructor(): super()
    override fun add(e: E, index: Int) {
        checkIfOutOfBound(index)
        if (size == 0) {
            val newNode = DoublyNode(e)
            newNode.next = newNode
            newNode.pre = newNode
            first == newNode
            last == newNode
        } else {
            val nextNode = findNode(index)
            val newNode = DoublyNode(nextNode.pre, e, nextNode)
            val preNode = nextNode.pre
            nextNode.pre = newNode
            preNode!!.next = newNode
        }
        size ++
        println(toString())
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
    
    override fun toString(): String {
        val sb = StringBuilder("CircularDoublyLinked: first [")
        var node = first
        for (i in 0 until size - 1) {
            sb.append(node.toString())
            node = node!!.next
        }
        sb.append("NULL]")
        return sb.toString()
    }
    
    private fun findNode(index: Int): DoublyNode<E> {
        val halfSize = size / 2
        var resNode: DoublyNode<E>?
        if (index >= halfSize) {
            resNode = last
            for (i in index until size) {
                resNode = resNode!!.pre
            }
        } else {
            resNode = first
            for (i in 0 until index)
                resNode = resNode!!.next
        }
        return resNode as DoublyNode<E>
    }
}
fun main(){
    var linked = CircularDoublyLinked<Int>()
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