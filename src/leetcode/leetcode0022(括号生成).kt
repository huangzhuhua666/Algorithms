package leetcode

import java.lang.StringBuilder

/**
 * Create by hzh on 2024/2/2.
 * 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 */
fun main() {
    println(generateParenthesis(3))
    println(generateParenthesis(1))
}

private val GEN = StringBuilder()

/**
 * 回溯法
 */
private fun generateParenthesis(n: Int): List<String> {
    if (n == 0) {
        return emptyList()
    }
    if (n == 1) {
        return listOf("()")
    }

    val result = mutableListOf<String>()
    backtrack(result, 0, 0, n)
    return result
}

private fun backtrack(result: MutableList<String>, open: Int, close: Int, max: Int) {
    if (GEN.length == 2 * max) {
        result.add(GEN.toString())
        return
    }

    if (open < max) {
        GEN.append("(")
        backtrack(result, open + 1, close, max)
        GEN.deleteCharAt(GEN.lastIndex)
    }

    if (close < open) {
        GEN.append(")")
        backtrack(result, open, close + 1, max)
        GEN.deleteCharAt(GEN.lastIndex)
    }
}