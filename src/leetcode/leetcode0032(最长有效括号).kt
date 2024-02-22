package leetcode

import java.util.*
import kotlin.math.max

/**
 * Create by hzh on 2024/2/22.
 * 最长有效括号
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 * 示例 3：
 * 输入：s = ""
 * 输出：0
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