package leetcode

import java.lang.StringBuilder

/**
 * Create by hzh on 2024/2/2.
 * ��������
 *
 * ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ�����Ч��������ϡ�
 *
 * ʾ�� 1��
 * ���룺n = 3
 * �����["((()))","(()())","(())()","()(())","()()()"]
 *
 * ʾ�� 2��
 * ���룺n = 1
 * �����["()"]
 */
fun main() {
    println(generateParenthesis(3))
    println(generateParenthesis(1))
}

private val GEN = StringBuilder()

/**
 * ���ݷ�
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