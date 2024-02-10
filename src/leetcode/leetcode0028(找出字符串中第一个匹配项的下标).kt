package leetcode

import KMP

/**
 * Create by hzh on 2024/2/9.
 * 找出字符串中第一个匹配项的下标
 *
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
fun main() {
    println(strStr1("sadbutsad", "sad"))
    println(strStr1("leetcode", "leeto"))
    println(strStr2("sadbutsad", "sad"))
    println(strStr2("leetcode", "leeto"))
    println(strStr3("sadbutsad", "sad"))
    println(strStr3("leetcode", "leeto"))
}

/**
 * 简单难度？？？直接用库
 */
private fun strStr1(haystack: String, needle: String): Int {
    return haystack.indexOf(needle)
}

/**
 * 暴力解
 */
private fun strStr2(haystack: String, needle: String): Int {
    if (haystack.isEmpty() || needle.isEmpty()) {
        return -1
    }

    val patLen = needle.length
    for (i in 0..haystack.length - patLen) {
        var match = true
        for (j in 0 until patLen) {
            if (haystack[i + j] != needle[j]) {
                match = false
                break
            }
        }

        if (match) {
            return i
        }
    }

    return -1
}

/**
 * KMP:[https://zhuanlan.zhihu.com/p/83334559]
 */
private fun strStr3(haystack: String, needle: String): Int {
    if (haystack.isEmpty() || needle.isEmpty()) {
        return -1
    }

    return KMP(needle).search(haystack)
}