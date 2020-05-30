package offer

import ListNode
import kotlin.math.abs

/**
 * Create by hzh on 2020/5/30.
 * 两个链表的第一个公共结点
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
fun main() {
    val head1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3)
        }
    }

    val head2 = ListNode(4).apply {
        next = ListNode(5).apply {
            next = ListNode(6).apply {
                next = ListNode(7).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                }
            }
        }
    }

    println(findFirstCommonNode(head1, head2)?.value)
}

private fun findFirstCommonNode(pHead1: ListNode?, pHead2: ListNode?): ListNode? =
        if (pHead1 == null || pHead2 == null) null
        else {
            var len1 = 0
            var len2 = 0
            var head1: ListNode? = pHead1
            var head2: ListNode? = pHead2

            while (head1 != null) {
                ++len1
                head1 = head1.next
            }

            while (head2 != null) {
                ++len2
                head2 = head2.next
            }

            var shortList: ListNode?
            var longList: ListNode?

            if (len1 < len2) {
                shortList = pHead1
                longList = pHead2
            } else {
                shortList = pHead2
                longList = pHead1
            }

            for (i in 0 until abs(len1 - len2)) {
                longList = longList?.next
            }

            var result: ListNode? = null
            while (longList != null) {
                if (longList.value == shortList?.value) {
                    result = longList
                    break
                }

                shortList = shortList?.next
                longList = longList.next
            }

            result
        }