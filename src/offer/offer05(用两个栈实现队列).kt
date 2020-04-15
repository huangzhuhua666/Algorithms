package offer

import java.util.*

/**
 * Create by hzh on 2020/3/20.
 * 用两个栈实现队列
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
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