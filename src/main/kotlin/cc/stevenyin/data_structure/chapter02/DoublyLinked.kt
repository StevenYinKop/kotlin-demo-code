package cc.stevenyin.data_structure.chapter02

import cc.stevenyin.data_structure.api.AbstractList
import cc.stevenyin.data_structure.model.DoublyNode
import java.util.concurrent.ThreadLocalRandom

class DoublyLinked<E>: AbstractList<E> {
    private var first: DoublyNode<E>? = null
    private var last: DoublyNode<E>? = null
    constructor(): super()
    override fun add(e: E, index: Int) {
        if (index == size) {
            if (size == 0) {
                first = DoublyNode(null, e, null)
                last = first
            }
            else {
                var pre = findNode(size - 1)
                var cur = DoublyNode(pre, e, null)
                pre.next = cur
                last = cur
            }
        } else {
            var next = findNode(index)
            var pre = next.pre
            var cur = DoublyNode(pre, e, next)
            if (pre == null) first = cur
            else pre.next = cur
            next.pre = cur
        }
        size ++
        println(this.toString())
    }

    override fun get(index: Int) = findNode(index).value
    override fun set(index: Int, e: E) {
        findNode(index).value = e
    }

    override fun findIndex(e: E): Int {
        var node = first
        var index = 0
        while (node != null) {
            if (node.value == null && e == null) return index
            if (e != null && e.equals(node.value)) return index
            index++
        }
        return -1
    }

    override fun del(index: Int): E {
        val node = findNode(index)
        val pre = node.pre
        val next = node.next
        if (pre == null) {
            first = next
        } else {
            pre.next = next
        }
        if (next == null) {
            last = pre
        } else {
            next.pre = pre
        }
        size--
        println(this.toString())
        return node.value
    }
    override fun toString(): String {
        var node = first
        val sb = StringBuffer("Linked[head]: ");
        while (node != null) {
            sb.append("${node.value} <-> ")
            node = node.next
        }
        sb.append("NULL [last]");
        return sb.toString()
    }
    private fun findNode(index: Int): DoublyNode<E> {
        checkIfOutOfBound(index)
        val halfSize = size / 2
        var node: DoublyNode<E>?
        if (index < halfSize) {
            node = first
            for (i in 0 until index) {
                node = node!!.next
            }
        } else {
            node = last
            for (i in index until size - 1) {
                node = node!!.pre
            }
        }
        return node as DoublyNode
    }
}
fun main(){
    var linked = DoublyLinked<Int>()
    linked.addFirst(11) // 11
    linked.addLast(22) // 11 -> 22
    linked.addLast(33) // 11 -> 22 -> 33
    linked.addFirst(44) // 44 -> 11 -> 22 -> 33
    linked.add(55, 1) // 44 -> 55 -> 11 -> 22 -> 33
    linked.add(66, linked.size) // 44 -> 55 -> 11 -> 22 -> 33 -> 66
    linked.add(77, linked.size / 2) // 44 -> 55 -> 11 -> 77 -> 22 -> 33 -> 66
    while(!linked.isEmpty()) {
        val index = ThreadLocalRandom.current().nextInt(0, linked.size)
        print("删除索引为$index 的元素: ")
        linked.del(index);
    }
}