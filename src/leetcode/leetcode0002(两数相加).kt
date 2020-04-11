package leetcode

import ListNode

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
    val l1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }

    val l2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }

    var newNum = addTwoNumbers(l1, l2)
    while (newNum != null) {
        print(newNum.value)
        newNum = newNum.next
    }
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? = if (l1 == null) l2
else if (l2 == null) l1
else {
    var p = l1
    var q = l2
    val head = ListNode(0)
    var currNode: ListNode? = head
    var flag = 0

    while (p != null || q != null) {
        val x = p?.value ?: 0
        val y = q?.value ?: 0
        val sum = x + y + flag
        if (sum < 10) { // 无需进位
            flag = 0
            currNode?.next = ListNode(sum)
        } else { // 进位
            flag = 1
            currNode?.next = ListNode(sum % 10)
        }

        p = p?.next
        q = q?.next
        currNode = currNode?.next
    }

    if (flag == 1) currNode?.next = ListNode(1)

    head.next
}