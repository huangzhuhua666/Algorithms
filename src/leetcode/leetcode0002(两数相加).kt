package leetcode

import ListNode
import toListNode

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
    var newNum = addTwoNumbers(listOf(2, 4, 5).toListNode(), listOf(5, 6, 4).toListNode())
    while (newNum != null) {
        print(newNum.value)
        newNum = newNum.next
    }
}

/**
 * ������Ԫ�طֱ���ӣ���Ҫ���ǽ�λ�����������Ҫ�������������Ȳ�һ�������
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
            // ����н�λҪ+1
            val sum = (p?.value ?: 0) + (q?.value ?: 0) + if (flag) {
                1
            } else {
                0
            }
            // �Ƿ����˽�λ
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