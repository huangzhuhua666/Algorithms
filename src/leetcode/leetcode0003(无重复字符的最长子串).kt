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
}

private fun lengthOfLongestSubString(s: String): Int = when {
    s.length < 2 -> s.length
    s.length == 2 -> if (s[0] == s[1]) 1 else 2
    else -> {
        var result = -1
        val map = mutableMapOf<Char, Int>()

        var index = 0
        while (index < s.length) {
            val c = s[index]
            if (map.containsKey(c)) {
                index = map[c]!!
                map.clear()
            } else {
                map[c] = index
                result = max(result, map.size)
            }

            ++index
        }

        result
    }
}