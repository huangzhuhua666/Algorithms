package offer

/**
 * Create by hzh on 2020/4/17.
 * 复杂链表的复制
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 */
private class RandomListNode(val label: Int) {

    var next: RandomListNode? = null
    var random: RandomListNode? = null
}

fun main() {
    val head = RandomListNode(1)
    val node2 = RandomListNode(2)
    val node3 = RandomListNode(3)
    val node4 = RandomListNode(4)
    val node5 = RandomListNode(5)

    head.run {
        next = node2
        random = node4
    }

    node2.next = node3

    node3.run {
        next = node4
        random = node5
    }

    node4.next = node5

    var node = clone(head)

    println(node?.random?.label)
    println(node?.next?.next?.random?.label)

    while (node != null) {
        print("${node.label}\t")
        node = node.next
    }
}

private fun clone(head: RandomListNode?): RandomListNode? {
    if (head == null) return null

    cloneNode(head)
    connectRandom(head)
    return splitNode(head)
}

/**
 * 按顺序复制一份链表，把它们连接在一起
 * 如：1 -> 2 -> 3 -> 4 -> 5 (1 random 4, 3 random 5)
 * 则：1 -> 1' -> 2 -> 2' -> 3 -> 3' -> 4 -> 4' -> 5 -> 5'
 */
private fun cloneNode(head: RandomListNode) {
    var node: RandomListNode? = head

    while (node != null) {
        val clone = RandomListNode(node.label).apply { next = node!!.next }
        node.next = clone
        node = clone.next
    }
}

/**
 * 在链接复制后的链表的随机结点
 * 则(1 random 4, 1' random 4', 3 random 5, 3' random 5')
 */
private fun connectRandom(head: RandomListNode) {
    var node: RandomListNode? = head

    while (node != null) {
        node.next?.random = node.random?.next
        node = node.next?.next
    }
}

/**
 * 分开两个链表
 */
private fun splitNode(head: RandomListNode): RandomListNode? {
    val newHead = head.next
    var node: RandomListNode? = head

    while (node != null) {
        val clone = node.next
        node.next = clone?.next
        clone?.next = clone?.next?.next
        node = node.next
    }

    return newHead
}