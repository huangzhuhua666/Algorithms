package nowcoder

import ListNode

/**
 * Create by hzh on 2020/3/26.
 * �ϲ��������������
 *
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
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
        if (list1 == null && list2 == null) null // �����б�ͬʱΪ�գ�����null
        else if (list1 == null) list2 // list1Ϊ�գ�ֱ�ӷ���list2
        else if (list2 == null) list1 // list2Ϊ�գ�ֱ�ӷ���list1
        else {
            var head: ListNode? = null // ���б��ͷ���
            var curr: ListNode? = null
            var p = list1
            var q = list2

            while (p != null && q != null) {
                if (p.value <= q.value) { // list1ͷ����ֵС�ڡ�����list2ͷ����ֵ
                    if (head == null) { // ���б��ͷ���Ϊ��
                        head = p
                        curr = head
                    } else {
                        curr!!.next = p
                        curr = curr.next
                    }
                    p = p.next
                } else { // list1ͷ����ֵ����list2ͷ����ֵ
                    if (head == null) { // ���б��ͷ���Ϊ��
                        head = q
                        curr = head
                    } else {
                        curr!!.next = q
                        curr = curr.next
                    }
                    q = q.next
                }
            }

            if (p == null) curr?.next = q // list1�����꣬list2��û������
            if (q == null) curr?.next = p // list2�����꣬list1��û������

            head
        }