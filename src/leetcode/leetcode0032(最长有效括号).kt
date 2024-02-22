package leetcode

import java.util.*
import kotlin.math.max

/**
 * Create by hzh on 2024/2/22.
 * ���Ч����
 *
 * ����һ��ֻ���� '(' �� ')' ���ַ������ҳ����Ч����ʽ��ȷ�������������Ӵ��ĳ��ȡ�
 *
 * ʾ�� 1��
 * ���룺s = "(()"
 * �����2
 * ���ͣ����Ч�����Ӵ��� "()"
 *
 * ʾ�� 2��
 * ���룺s = ")()())"
 * �����4
 * ���ͣ����Ч�����Ӵ��� "()()"
 *
 * ʾ�� 3��
 * ���룺s = ""
 * �����0
 */
fun main() {
    println(longestValidParentheses("(()"))
    println(longestValidParentheses(")()())"))
    println(longestValidParentheses(""))
    println(longestValidParentheses("()(()"))
}

private fun longestValidParentheses(s: String): Int {
    if (s.isEmpty() || s.length == 1) {
        return 0
    }

    val stack = Stack<Int>()
    val marks = MutableList(s.length) { 0 }
    s.forEachIndexed { index, c ->
        when (c) {
            '(' -> {
                stack.push(index)
            }
            ')' -> {
                if (stack.isEmpty()) {
                    marks[index] = 1
                } else {
                    stack.pop()
                }
            }
        }
    }
    while (!stack.isEmpty()) {
        marks[stack.pop()] = 1
    }

    var result = 0
    var count = 0
    marks.forEach {
        if (it == 0) {
            ++count
            result = max(result, count)
        } else {
            result = max(result, count)
            count = 0
        }
    }

    return result
}