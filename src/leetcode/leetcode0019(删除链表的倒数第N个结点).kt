package leetcode

import ListNode
import toList
import toListNode

/**
 * Create by hzh on 2024/2/1.
 * ɾ������ĵ�����N�����
 *
 * ����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣
 */
fun main() {
    println(removeNthFromEnd(listOf(1, 2, 3, 4, 5).toListNode(), 2).toList())
    println(removeNthFromEnd(listOf(1).toListNode(), 1).toList())
    println(removeNthFromEnd(listOf(1, 2).toListNode(), 1).toList())
    println(removeNthFromEnd(listOf(1, 2).toListNode(), 2).toList())
}

private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head?.next == null) {
        return null
    }
    if (n <= 0) {
        return head
    }

    val newHead = ListNode(0).also {
        it.next = head
    }

    var p = head
    var q: ListNode? = newHead
    repeat(n) {
        p = p?.next
    }

    while (p != null) {
        p = p?.next
        q = q?.next
    }

    q?.next = q?.next?.next

    return newHead.next
}