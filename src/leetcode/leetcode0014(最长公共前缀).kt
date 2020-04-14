package leetcode

import kotlin.math.min

/**
 * Create by hzh on 2020/4/14.
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 */
fun main() {
    println(longestCommonPrefix1(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix1(arrayOf("dog", "racecar", "car")))

    println(longestCommonPrefix2(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix2(arrayOf("dog", "racecar", "car")))

    println(longestCommonPrefix3(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix3(arrayOf("dog", "racecar", "car")))
}

/**
 * 取数组第一个字符串，然后与其他每一个字符串对比每一列的字符
 */
private fun longestCommonPrefix1(strs: Array<String>): String = when (strs.isEmpty()) {
    true -> ""
    false -> {
        strs[0].forEachIndexed { i, c ->
            for (j in 1 until strs.size) {
                if (i == strs[j].length || c != strs[j][i])
                    return strs[0].substring(0, i)
            }
        }

        strs[0]
    }
}

/**
 * 分治法，求解每个子问题
 */
private fun longestCommonPrefix2(strs: Array<String>): String = when (strs.isEmpty()) {
    true -> ""
    false -> longestCommonPrefix2(strs, 0, strs.size - 1)
}

private fun longestCommonPrefix2(strs: Array<String>, left: Int, right: Int): String =
        when (left == right) {
            true -> strs[left]
            false -> {
                val mid = (left + right) / 2
                val leftPart = longestCommonPrefix2(strs, left, mid)
                val rightPart = longestCommonPrefix2(strs, mid + 1, right)

                commonPrefix(leftPart, rightPart)
            }
        }

private fun commonPrefix(str1: String, str2: String): String {
    val min = min(str1.length, str2.length)

    for (i in 0 until min) {
        if (str1[i] != str2[i]) return str1.substring(0, i)
    }

    return str1.substring(0, min)
}

/**
 * 二分查找
 */
private fun longestCommonPrefix3(strs: Array<String>): String = when (strs.isEmpty()) {
    true -> ""
    false -> {
        var minLen = Int.MAX_VALUE
        strs.forEach { minLen = min(minLen, it.length) } // 找到最短的字符串

        var left = 1
        var right = minLen

        while (left <= right) {
            val mid = (left + right) / 2

            if (isCommonPrefix(strs, mid)) left = mid + 1 // 如果前半部分是公共前缀，往后半部分查找
            else right = mid - 1 // 否则，往前半部分搜索
        }

        strs[0].substring(0, (left + right) / 2)
    }
}

private fun isCommonPrefix(strs: Array<String>, len: Int): Boolean {
    val prefix = strs[0].substring(0, len)

    strs.forEach { if (!it.startsWith(prefix)) return false }

    return true
}