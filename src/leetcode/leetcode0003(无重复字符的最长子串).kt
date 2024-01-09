package leetcode

import kotlin.math.max

/**
 * Create by hzh on 2020/4/10.
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 */
fun main() {
    println(lengthOfLongestSubString("abcabcbb"))
    println(lengthOfLongestSubString("bbbbb"))
    println(lengthOfLongestSubString("pwwkew"))
    println(lengthOfLongestSubString(" "))
    println(lengthOfLongestSubString(""))
    println(lengthOfLongestSubString("a"))
    println(lengthOfLongestSubString("au"))
    println(lengthOfLongestSubString("tmmzuxt"))
}

/**
 * 滑动窗口，如果map有该字符的记录，则滑动窗口的left需要左移，注意不要让left右移了，例如上面"tmmzuxt"这种情况
 */
private fun lengthOfLongestSubString(s: String): Int {
    var result = 0
    val map = mutableMapOf<Char, Int>()

    var left = 0
    s.forEachIndexed { index, c ->
        if (map.containsKey(c)) {
            left = max(left, (map[c] ?: 0) + 1)
        }

        map[c] = index

        result = max(result, index - left + 1)
    }

    return result
}