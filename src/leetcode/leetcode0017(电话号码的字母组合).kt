package leetcode

import java.lang.StringBuilder

/**
 * Create by hzh on 2024/1/30.
 * 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
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