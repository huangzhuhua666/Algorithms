package leetcode

import ListNode
import toList
import toListNode
import java.util.*

/**
 * Create by hzh on 2024/2/6.
 * K��һ�鷭ת����
 *
 * ���������ͷ�ڵ� head ��ÿ k ���ڵ�һ����з�ת�����㷵���޸ĺ������
 * k ��һ��������������ֵС�ڻ��������ĳ��ȡ�����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʽ��нڵ㽻����
 *
 * ʾ�� 1��
 * ���룺head = [1,2,3,4,5], k = 2
 * �����[2,1,4,3,5]
 *
 * ʾ�� 2��
 * ���룺head = [1,2,3,4,5], k = 3
 * �����[3,2,1,4,5]
 *
 * ���ף���������һ��ֻ�� O(1) �����ڴ�ռ���㷨�����������
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
 * ջ
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
 * ������⣬��ָ��ÿ�� k ��������һ����ָ�� -> ��ָ�벿�ֵ�������ת
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