package com.stevenyin.leetcode
/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class _0876_MiddleOfLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        if (head == null) return head
        var fast = head.next
        var slow = head
        while (fast != null) {
            slow = slow!!.next
            fast = fast.next
            if (fast != null) fast = fast.next
            else return slow
        }
        return slow
    }
}