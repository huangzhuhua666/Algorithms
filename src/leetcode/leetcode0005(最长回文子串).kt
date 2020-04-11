package leetcode

/**
 * Create by hzh on 2020/4/10.
 * 最长回文子串
 *
 * 给定一个字符串s，找到s中最长的回文子串。你可以假设s的最大长度为 1000。
 */
fun main() {
    println(longestPalindrome1("babad"))
    println(longestPalindrome2("babad"))
}

/**
 * 中间扩散法
 * 从某一字符串开始，先向左遍历直到找不到与他相同的字符，记录left
 * 再向右遍历直到找不到与他相同的字符，记录right
 * 最后再同时向左向右遍历直到左右字符不相同，记录left、right、len
 * 如果len > maxLen，记录此时的maxStart = left + 1
 */
private fun longestPalindrome1(s: String): String = when (s.length) {
    0 -> ""
    1 -> s
    else -> {
        var maxLen = 1
        var maxStart = 0

        for (i in s.indices) {
            var len = 1
            var left = i - 1
            var right = i + 1

            while (left > 0 && s[left] == s[i]) { // 向左遍历，直到没有与它相同的字符
                ++len
                --left
            }

            while (right < s.length && s[right] == s[i]) { // 向右遍历，直到没有与它相同的字符
                ++len
                ++right
            }

            // 同时向左、向右扩散遍历，直到左右字符不相同
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                len += 2
                --left
                ++right
            }

            if (len > maxLen) {
                maxLen = len
                maxStart = left + 1
            }
        }

        s.substring(maxStart, maxStart + maxLen)
    }
}

/**
 * 动态规划法
 * 用dp[left][right]表示从left-right是否为回文串
 * 若dp[left][right] = true，
 * 则要判断dp[left - 1][right + 1]是否为回文串，只需判断left - 1与right + 1的字符是否相同即可
 */
private fun longestPalindrome2(s: String): String = when (s.length) {
    0 -> ""
    1 -> s
    else -> {
        val dp = Array(s.length) { out -> BooleanArray(s.length) { it == out } }

        var maxLen = 1
        var maxStart = 0

        for (right in 1 until s.length) {
            for (left in 0 until right) {
                if (s[left] == s[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true

                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1
                        maxStart = left
                    }
                }
            }
        }

        s.substring(maxStart, maxStart + maxLen)
    }
}