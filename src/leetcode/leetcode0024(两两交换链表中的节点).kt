package leetcode

import ListNode
import toList
import toListNode

/**
 * Create by hzh on 2024/2/6.
 * �������������еĽڵ�
 *
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������ͷ�ڵ㡣
 * ������ڲ��޸Ľڵ��ڲ���ֵ���������ɱ��⣨����ֻ�ܽ��нڵ㽻������
 *
 * ʾ�� 1��
 * ���룺head = [1,2,3,4]
 * �����[2,1,4,3]
 *
 * ʾ�� 2��
 * ���룺head = []
 * �����[]
 *
 * ʾ�� 3��
 * ���룺head = [1]
 * �����[1]
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