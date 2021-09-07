package cc.stevenyin.leetcode

/**
 *  https://leetcode.com/problems/remove-linked-list-elements/
 */
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class _203_Remove_Linked_List_Elements {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var dummyHead = ListNode(-1)
        dummyHead.next = head
        var node: ListNode? = dummyHead
        while (node!!.next != null) {
            if(node.next!!.`val` == `val`)
                node.next = node.next!!.next
            else
                node = node.next
        }
        return dummyHead.next
    }
}
fun main(args: Array<String>) {
    val params = intArrayOf(1,2,6,3,4,5,6)
    var node = ListNode(-1)
    val head = node
    for (i in params) {
        node.next = ListNode(i)
        node = node.next as ListNode
    }
    _203_Remove_Linked_List_Elements().removeElements(head.next, 6)
}