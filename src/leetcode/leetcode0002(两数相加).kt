package leetcode

import ListNode
import toListNode

/**
 * Create by hzh on 2020/4/10.
 * 两数相加
 *
 * 给出两个非空的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字0之外，这两个数都不会以0开头。
 */
fun main() {
    var newNum = addTwoNumbers(listOf(2, 4, 5).toListNode(), listOf(5, 6, 4).toListNode())
    while (newNum != null) {
        print(newNum.value)
        newNum = newNum.next
    }
}

/**
 * 两链表元素分别相加，需要考虑进位的情况，还有要考虑两个链表长度不一样的情况
 */
private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? = when {
    l1 == null -> l2
    l2 == null -> l1
    else -> {
        val result = ListNode(0)
        var currNode: ListNode? = result

        var p = l1
        var q = l2

        var flag = false
        while (p != null || q != null) {
            // 如果有进位要+1
            val sum = (p?.value ?: 0) + (q?.value ?: 0) + if (flag) {
                1
            } else {
                0
            }
            // 是否发生了进位
            flag = sum >= 10

            currNode?.next = ListNode(sum % 10)
            currNode = currNode?.next

            p = p?.next
            q = q?.next
        }

        if (flag) {
            currNode?.next = ListNode(1)
        }

        result.next
    }
}