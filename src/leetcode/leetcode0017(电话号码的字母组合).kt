package leetcode

import java.lang.StringBuilder

/**
 * Create by hzh on 2024/1/30.
 * �绰�������ĸ���
 *
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 *
 * ʾ�� 1��
 * ���룺digits = "23"
 * �����["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * ʾ�� 2��
 * ���룺digits = ""
 * �����[]
 *
 * ʾ�� 3��
 * ���룺digits = "2"
 * �����["a","b","c"]
 *
 * ��ʾ��
 * 0 <= digits.length <= 4
 * digits[i] �Ƿ�Χ ['2', '9'] ��һ�����֡�
 */
fun main() {
    println(letterCombinations("23"))
    println(letterCombinations(""))
    println(letterCombinations("2"))
}

private val LETTER = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
)

private fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) {
        return emptyList()
    }

    val result = mutableListOf<String>()

    backtrack(result, digits, 0, StringBuilder())

    return result
}

private fun backtrack(
        result: MutableList<String>,
        digits: String,
        index: Int,
        combination: StringBuilder
) {
    if (index == digits.length) {
        result.add(combination.toString())
    } else {
        LETTER[digits[index]]?.forEach {
            combination.append(it)
            backtrack(result, digits, index + 1, combination)
            combination.deleteCharAt(index)
        }
    }
}