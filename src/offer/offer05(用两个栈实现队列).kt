package offer

import java.util.*

/**
 * Create by hzh on 2020/3/20.
 * ������ջʵ�ֶ���
 *
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */
fun main() {
    val queue = StackToQueue()
    queue.push(1)
    queue.push(2)
    queue.push(3)
    queue.push(4)
    println(queue.pop())
    println(queue.pop())
    queue.push(5)
    queue.push(6)
    println(queue.pop())
    println(queue.pop())
    println(queue.pop())
    println(queue.pop())
}

private class StackToQueue {

    private val stack1 = Stack<Int>()
    private val stack2 = Stack<Int>()

    fun push(node: Int) {
        stack1.push(node)
    }

    fun pop(): Int {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop())
            }
        }

        return stack2.pop()
    }
}