package cc.stevenyin.leetcode
/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class _0083_RemoveDuplicatesFromSortedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var node = head
        while (node != null && node.next != null) {
            if (node.`val` == node.next?.`val`) node.next = node.next?.next
            else node = node.next
        }
        return head
    }
}

