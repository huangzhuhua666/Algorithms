package offer

import java.util.*

/**
 * Create by hzh on 2020/4/16.
 * ջ��ѹ�롢��������
 *
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 */
fun main() {
    println(isPopOrder(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
    println(isPopOrder(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 3, 5, 1, 2)))
}

private fun isPopOrder(pushA: IntArray, popA: IntArray): Boolean = when {
    pushA.size != popA.size -> false
    else -> {
        val stack = Stack<Int>()

        var j = 0
        for (i in pushA.indices) {
            stack.push(pushA[i])

            while (stack.isNotEmpty() && stack.peek() == popA[j]) {
                stack.pop()
                ++j
            }
        }

        stack.isEmpty()
    }
}