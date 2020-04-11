package nowcoder

import ListNode

/**
 * Create by hzh on 2020/3/25.
 * �����е�����k�����
 *
 * ����һ����������������е�����k����㡣
 */
fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }
    }
    println(findKthToTail(head, 2)?.value)
}

/**
 * ����ָ�룬��ָ������k����ע��k��ֵ���������ȵ������
 */
private fun findKthToTail(head: ListNode?, k: Int): ListNode? = if (head == null) null
else {
    var fast: ListNode? = head
    var curr = k
    while (fast != null && curr > 0) {
        fast = fast.next
        --curr
    }

    if (curr != 0) null
    else {
        var slow = head

        while (fast != null) {
            slow = slow!!.next
            fast = fast.next
        }

        slow
    }
}