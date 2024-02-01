package leetcode

import java.util.*

/**
 * Create by hzh on 2024/2/1.
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1、左括号必须用相同类型的右括号闭合。
 * 2、左括号必须以正确的顺序闭合。
 * 3、每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 */
fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
    println(isValid("]"))
}

private fun isValid(s: String): Boolean {
    val stack = Stack<Char>()

    s.forEach {
        if (it in listOf('(', '[', '{')) {
            stack.push(it)
        } else {
            if (stack.isEmpty()) {
                return false
            }

            when (it) {
                ')' -> {
                    if (stack.pop() !=  '(') {
                        return false
                    }
                }
                ']' -> {
                    if (stack.pop() != '[') {
                        return false
                    }
                }
                '}' -> {
                    if (stack.pop() != '{') {
                        return false
                    }
                }
            }
        }
    }

    return stack.isEmpty()
}