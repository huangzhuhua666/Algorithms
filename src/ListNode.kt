/**
 * Create by hzh on 2020/3/17.
 */
class ListNode(var value: Int) {

    var next: ListNode? = null
}

fun ListNode?.toList(): List<Int> {
    val result = mutableListOf<Int>()

    var p: ListNode? = this
    while (p != null) {
        result.add(p.value)
        p = p.next
    }

    return result
}

fun List<Int>.toListNode(): ListNode? {
    val head = ListNode(0)
    var p: ListNode? = head

    forEach {
        p?.next = ListNode(it)
        p = p?.next
    }

    return head.next
}