package leetcode

import ListNode
import toList
import toListNode
import java.util.*

/**
 * Create by hzh on 2024/2/5.
 * �ϲ�K����������
 *
 * ����һ���������飬ÿ�������Ѿ����������С�
 * ���㽫��������ϲ���һ�����������У����غϲ��������
 *
 * ʾ�� 1��
 * ���룺lists = [[1,4,5],[1,3,4],[2,6]]
 * �����[1,1,2,3,4,4,5,6]
 * ���ͣ������������£�
 * [
 *      1->4->5,
 *      1->3->4,
 *      2->6
 * ]
 * �����Ǻϲ���һ�����������еõ���
 * 1->1->2->3->4->4->5->6
 *
 * ʾ�� 2��
 * ���룺lists = []
 * �����[]
 *
 * ʾ�� 3��
 * ���룺lists = [[]]
 * �����[]
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
 * ���η�������⣬������ɺϲ�������������
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
 * ���ȶ��У���ÿ������ͷ�ĵ�һ��Ԫ�����
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