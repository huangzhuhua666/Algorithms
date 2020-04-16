package offer

import java.util.*

/**
 * Create by hzh on 2020/4/16.
 * ����min������ջ
 *
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
 * ע�⣺��֤�����в��ᵱջΪ�յ�ʱ�򣬶�ջ����pop()����min()����top()������
 */
private var size = 0
private var min = Int.MAX_VALUE
private val minStack = Stack<Int>()
private var elements = Array<Int?>(10) { null }

fun main() {
    pop()
    push(1)
    push(2)
    push(3)
    push(-1)
    println(min())
    pop()
    println(min())
    pop()
    println(min())
}

private fun push(node: Int) {
    ensureCapacity(size + 1)
    elements[size++] = node

    if (node < min) {
        minStack.push(node)
        min = node
    } else minStack.push(min)
}

private fun pop() {
    top()?.run {
        elements[size - 1] = null

        --size
        minStack.pop()
        min = minStack.peek()
    }
}

private fun top(): Int? = when (isEmpty()) {
    true -> null
    false -> if (size - 1 >= 0) elements[size - 1] else null
}

private fun min(): Int = min

private fun isEmpty(): Boolean = size == 0

private fun ensureCapacity(size: Int) {
    val len = elements.size
    if (size > len) {
        val newLen = (len * 3) / 2 + 1
        elements = elements.copyOf(newLen)
    }
}