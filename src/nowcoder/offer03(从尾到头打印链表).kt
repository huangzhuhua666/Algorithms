package nowcoder

import ListNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * Create by hzh on 2020/3/17.
 * 从尾到头打印链表
 *
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }
    }
    printListFromTailToHead(head).forEach(::println)
}

private fun printListFromTailToHead(listNode: ListNode?): ArrayList<Int> {
    if (listNode == null) return arrayListOf()

    val stack = Stack<Int>()
    var currNode = listNode
    while (currNode != null) {
        stack.push(currNode.value)
        currNode = currNode.next
    }

    val list = arrayListOf<Int>()
    while (!stack.isEmpty()) {
        list.add(stack.pop())
    }

    return list
}