package leetcode

import ListNode
import toList
import toListNode
import java.util.*

/**
 * Create by hzh on 2024/2/5.
 * 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *      1->4->5,
 *      1->3->4,
 *      2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 */
fun main() {
    println(mergeKLists1(arrayOf(
            listOf(1, 4, 5).toListNode(),
            listOf(1, 3, 4).toListNode(),
            listOf(2, 6).toListNode()
    )).toList())
    println(mergeKLists1(arrayOf()).toList())
    println(mergeKLists1(arrayOf(listOf<Int>().toListNode())).toList())

    println(mergeKLists2(arrayOf(
            listOf(1, 4, 5).toListNode(),
            listOf(1, 3, 4).toListNode(),
            listOf(2, 6).toListNode()
    )).toList())
    println(mergeKLists2(arrayOf()).toList())
    println(mergeKLists2(arrayOf(listOf<Int>().toListNode())).toList())
    println(mergeKLists2(arrayOf(
            listOf<Int>().toListNode(),
            listOf<Int>().toListNode()
    )).toList())
}

/**
 * 分治法拆解问题，把它变成合并两个有序链表
 */
private fun mergeKLists1(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) {
        return null
    }
    if (lists.size == 1) {
        return lists.first()
    }
    if (lists.size == 2) {
        return mergeTwoLists(lists.getOrNull(0), lists.getOrNull(1))
    }

    return mergeKLists(lists, 0, lists.size - 1)
}

private fun mergeKLists(lists: Array<ListNode?>, left: Int, right: Int): ListNode? {
    if (left == right) {
        return lists.getOrNull(left)
    }
    if (left > right) {
        return null
    }

    val mid = (left + right) / 2
    return mergeTwoLists(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right))
}

private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) {
        return list2
    }
    if (list2 == null) {
        return list1
    }

    val newNodeHead = ListNode(0)
    var newNode: ListNode? = newNodeHead
    var p = list1
    var q = list2
    while (p != null && q != null) {
        val num1 = p.value
        val num2 = q.value
        if (num1 <= num2) {
            newNode?.next = ListNode(num1)
            p = p.next
        } else {
            newNode?.next = ListNode(num2)
            q = q.next
        }

        newNode = newNode?.next
    }

    if (p == null) {
        newNode?.next = q
    }
    if (q == null) {
        newNode?.next = p
    }

    return newNodeHead.next
}

/**
 * 优先队列，把每个链表头的第一个元素入队
 */
private fun mergeKLists2(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) {
        return null
    }
    if (lists.size == 1) {
        return lists.first()
    }

    val queue = PriorityQueue<ListNode> { o1, o2 ->
        (o1?.value ?: 0) - (o2?.value ?: 0)
    }

    lists.asSequence().filterNotNull().forEach {
        queue.offer(it)
    }

    val newHead = ListNode(0)
    var move: ListNode? = newHead
    while (queue.isNotEmpty()) {
        queue.poll()?.let {
            if (it.next != null) {
                queue.offer(it.next)
            }

            move?.next = ListNode(it.value)
            move = move?.next
        }
    }

    return newHead.next
}