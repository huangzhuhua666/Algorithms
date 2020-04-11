package leetcode

import ListNode

/**
 * Create by hzh on 2020/4/10.
 * �������
 *
 * ���������ǿյ�����������ʾ�����Ǹ���������
 * ���У����Ǹ��Ե�λ���ǰ�������ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢һλ���֡�
 * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
 * �����Լ����������0֮�⣬����������������0��ͷ��
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
        if (sum < 10) { // �����λ
            flag = 0
            currNode?.next = ListNode(sum)
        } else { // ��λ
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