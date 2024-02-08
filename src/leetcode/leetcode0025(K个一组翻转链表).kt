package leetcode

import ListNode
import toList
import toListNode
import java.util.*

/**
 * Create by hzh on 2024/2/6.
 * K个一组翻转链表
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */
fun main() {
    println(reverseKGroup1(listOf(1, 2, 3, 4, 5).toListNode(), 2).toList())
    println(reverseKGroup1(listOf(1, 2, 3, 4, 5).toListNode(), 3).toList())
    println(reverseKGroup1(listOf(1, 2).toListNode(), 2).toList())
    println(reverseKGroup2(listOf(1, 2, 3, 4, 5).toListNode(), 2).toList())
    println(reverseKGroup2(listOf(1, 2, 3, 4, 5).toListNode(), 3).toList())
    println(reverseKGroup2(listOf(1, 2).toListNode(), 2).toList())
}

/**
 * 栈
 */
private fun reverseKGroup1(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null || k == 1) {
        return head
    }

    val stack = Stack<ListNode>()

    val newHead = ListNode(0)
    var newHeadMove: ListNode? = newHead
    var move = head
    while (move != null) {
        stack.push(move)
        move = move.next

        if (stack.size == k) {
            while (stack.isNotEmpty()) {
                newHeadMove?.next = stack.pop()
                newHeadMove = newHeadMove?.next
            }
        }
    }

    newHeadMove?.next = if (stack.isNotEmpty()) {
         stack.firstElement()
    } else {
        null
    }

    return newHead.next
}

/**
 * 拆解问题，快指针每走 k 步，进行一次慢指针 -> 快指针部分的链表逆转
 */
private fun reverseKGroup2(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null || k == 1) {
        return head
    }

    val newHead = ListNode(0)
    var newHeadMove: ListNode? = newHead

    var quick = head
    var slow = head
    var count = 0
    while (quick != null) {
        ++count
        quick = quick.next

        if (count == k) {
            newHeadMove?.next = reverseList(slow, quick)
            newHeadMove = slow
            slow = quick

            count = 0
        }
    }

    if (count != 0) {
        newHeadMove?.next = slow
    }

    return newHead.next
}

private fun reverseList(head: ListNode?, end: ListNode?): ListNode? {
    if (head?.next == null) {
        return null
    }

    var move = head
    var preNode: ListNode? = null
    var nextNode: ListNode?
    while (move != end) {
        nextNode = move?.next
        move?.next = preNode
        preNode = move
        move = nextNode
    }

    return preNode
}