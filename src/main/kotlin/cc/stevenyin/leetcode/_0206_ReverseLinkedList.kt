package cc.stevenyin.leetcode

/**
 * https://leetcode.com/problems/reverse-linked-list/
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

class _0206_ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head
        val newHead = reverseList(head.next)
        head.next!!.next = head
        head.next = null
        return newHead
    }
}