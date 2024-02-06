package leetcode

import ListNode
import toList
import toListNode

/**
 * Create by hzh on 2024/2/6.
 * 两两交换链表中的节点
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 */
fun main() {
    println(swapPairs(listOf(1, 2, 3, 4).toListNode()).toList())
    println(swapPairs(listOf<Int>().toListNode()).toList())
    println(swapPairs(listOf(1).toListNode()).toList())
    println(swapPairs(listOf(1, 2, 3).toListNode()).toList())
}

private fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    val newHead = ListNode(0).also {
        it.next = head
    }
    var move: ListNode? = newHead
    var tempNode: ListNode?
    while (move?.next?.next != null) {
        tempNode = move.next
        move.next = tempNode?.next
        tempNode?.next = move.next?.next
        move.next?.next = tempNode

        move = move.next?.next
    }

    return newHead.next
}