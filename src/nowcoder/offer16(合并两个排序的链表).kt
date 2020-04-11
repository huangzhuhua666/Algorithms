package nowcoder

import ListNode

/**
 * Create by hzh on 2020/3/26.
 * 合并两个排序的链表
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
fun main() {
    val list1 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(7).apply {
                next = ListNode(9)
            }
        }
    }
    val list2 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(5).apply {
                next = ListNode(8).apply {
                    next = ListNode(10).apply {
                        next = ListNode(12)
                    }
                }
            }
        }
    }

    var list = merge(list1, list2)
    while (list != null) {
        print("${list.value} ")
        list = list.next
    }
    println()
}

private fun merge(list1: ListNode?, list2: ListNode?): ListNode? =
        if (list1 == null && list2 == null) null // 两个列表同时为空，返回null
        else if (list1 == null) list2 // list1为空，直接返回list2
        else if (list2 == null) list1 // list2为空，直接返回list1
        else {
            var head: ListNode? = null // 新列表的头结点
            var curr: ListNode? = null
            var p = list1
            var q = list2

            while (p != null && q != null) {
                if (p.value <= q.value) { // list1头结点的值小于、等于list2头结点的值
                    if (head == null) { // 新列表的头结点为空
                        head = p
                        curr = head
                    } else {
                        curr!!.next = p
                        curr = curr.next
                    }
                    p = p.next
                } else { // list1头结点的值大于list2头结点的值
                    if (head == null) { // 新列表的头结点为空
                        head = q
                        curr = head
                    } else {
                        curr!!.next = q
                        curr = curr.next
                    }
                    q = q.next
                }
            }

            if (p == null) curr?.next = q // list1遍历完，list2还没遍历完
            if (q == null) curr?.next = p // list2遍历完，list1还没遍历完

            head
        }