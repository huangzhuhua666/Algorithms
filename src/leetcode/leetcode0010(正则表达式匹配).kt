package leetcode

/**
 * Create by hzh on 2020/4/13.
 * 正则表达式匹配
 *
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持'.'和'*'的正则表达式匹配。
 * '.'匹配任意单个字符
 * '*'匹配零个或多个前面的那一个元素
 */
fun main() {
    println(isMatch1("aa", "a"))
    println(isMatch1("aa", "a*"))
    println(isMatch1("ab", ".*"))
    println(isMatch1("aab", "c*a*b"))
    println(isMatch1("mississippi", "mis*is*p*."))
    println(isMatch1("ab", ".*c"))
    println("---split line ---")
    println(isMatch2("aa", "a"))
    println(isMatch2("aa", "a*"))
    println(isMatch2("ab", ".*"))
    println(isMatch2("aab", "c*a*b"))
    println(isMatch2("mississippi", "mis*is*p*."))
    println(isMatch2("ab", ".*c"))
}

/**
 * 回溯法
 */
private fun isMatch1(s: String, p: String): Boolean = if (p.isEmpty()) s.isEmpty()
else {
    // 匹配第一个字符或'.'
    val isFirstMatch = s.isNotEmpty() && (s[0] == p[0] || p[0] == '.')

    // 如果模式串有星号，它会出现在第二个位置p[1]，
    // 此时：
    // 1.直接忽略模式串这一部分
    // 2.当模式串能匹配当前字符时，删除匹配串第一个字符
    // 当这两个条件其中一个成立时，可以被匹配
    if (p.length >= 2 && p[1] == '*')
        isMatch1(s, p.substring(2))
                || (isFirstMatch && isMatch1(s.substring(1), p))
    else // 无星号，匹配串和模式串同时后移，前提是模式串能匹配当前字符
        isFirstMatch && isMatch1(s.substring(1), p.substring(1))
}

private fun isMatch2(s: String, p: String): Boolean {
    val sLen = s.length
    val pLen = p.length
    val dp = Array(sLen + 1) { BooleanArray(pLen + 1) }
    dp[0][0] = true

    for (i in 0..sLen) {
        for (j in 1..pLen) {
            if (p[j - 1] == '*') {
                // 假设为 'a*'，把 'a*' 丢弃，则变成 dp[i][j - 2] 的问题
                dp[i][j] = dp[i][j - 2]
                // 如果当前字符和 '*' 的前一个字符匹配上，则固定 j，i - 1，变成 dp[i - 1][j] 的问题
                if (matches(s, p, i, j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j]
                }
            } else {
                if (matches(s, p, i, j)) {
                    // 字符匹配，且后面不为 '*'，则变成 dp[i - 1][j - 1] 的问题
                    dp[i][j] = dp[i - 1][j - 1]
                }
            }
        }
    }

    return dp[sLen][pLen]
}

/**
 * 判断单个字符是否相等，或者是否为'.'。i = 0 时，表示 s 为空字符串
 */
private fun matches(s: String, p: String, i: Int, j: Int): Boolean {
    if (i == 0) {
        return false
    }

    return s[i - 1] == p[j - 1] || p[j - 1] == '.'
}