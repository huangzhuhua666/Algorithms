package leetcode

import ListNode
import toList
import toListNode

/**
 * Create by hzh on 2024/2/1.
 * �ϲ�������������
 *
 * ��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
 *
 * ʾ�� 1��
 * ���룺l1 = [1,2,4], l2 = [1,3,4]
 * �����[1,1,2,3,4,4]
 *
 * ʾ�� 2��
 * ���룺l1 = [], l2 = []
 * �����[]
 *
 * ʾ�� 3��
 * ���룺l1 = [], l2 = [0]
 * �����[0]
 */
fun main() {
    println(mergeTwoLists(listOf(1, 2, 4).toListNode(), listOf(1, 3, 4).toListNode()).toList())
    println(mergeTwoLists(listOf<Int>().toListNode(), listOf<Int>().toListNode()).toList())
    println(mergeTwoLists(listOf<Int>().toListNode(), listOf(0).toListNode()).toList())
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