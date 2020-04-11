package nowcoder

import ListNode

/**
 * Create by hzh on 2020/3/25.
 * ��ת����
 *
 * ����һ��������ת��������������ı�ͷ��
 */
fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }
    }

    var curr = reverseList(head)
    while (curr != null) {
        print("${curr.value} ")
        curr = curr.next
    }
    println()
}

private fun reverseList(head: ListNode?): ListNode? = if (head?.next == null) head
else {
    var p = head
    var pre: ListNode? = null
    var next: ListNode?

    while (p != null) {
        next = p.next
        p.next = pre
        pre = p
        p = next
    }

    pre
}