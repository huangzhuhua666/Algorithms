package leetcode

/**
 * Create by hzh on 2024/3/6.
 * 通配符匹配
 *
 * 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符序列（包括空字符序列）。
 * 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
 *
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2：
 * 输入：s = "aa", p = "*"
 * 输出：true
 * 解释：'*' 可以匹配任意字符串。
 *
 * 示例 3：
 * 输入：s = "cb", p = "?a"
 * 输出：false
 * 解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 */
fun main() {
    println(isMatch("aa", "a"))
    println(isMatch("aa", "*"))
    println(isMatch("cb", "?a"))
    println(isMatch("aa", "*c"))
    println(isMatch("acdcb", "a*c?b"))
}

private fun isMatch(s: String, p: String): Boolean {
    val sLen = s.length
    val pLen = p.length
    val dp = Array(sLen + 1) { BooleanArray(pLen + 1) }
    dp[0][0] = true

    for (i in 1..pLen) {
        if (p[i - 1] == '*') {
            dp[0][i] = true
        } else {
            break
        }
    }

    for (i in 1..sLen) {
        for (j in 1..pLen) {
            when {
                p[j - 1] == '?' || s[i - 1] == p[j - 1] -> {
                    dp[i][j] = dp[i - 1][j - 1]
                }
                p[j - 1] == '*' -> {
                    /**
                     * 1、dp[i][j - 1] 的时候，'*' 表示空字符，保持 i 不变，j - 1 即为舍弃'*'，看前面的匹配情况
                     * 例如 s = "a"， p = "a*"， i = 1， j = 2 时，则 dp[i][j - 1] 可以理解为看 s = "a"，p="a" 是否匹配
                     **/
                    /**
                     * 2、dp[i - 1][j] 的时候，'*' 表示多个字符，把它保留，看当前字符之前的字符是否也能被 '*' 匹配
                     * 如果之前字符能，那么再加上现在的一个字符，'*' 就能匹配这几个连续字符了
                     */
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]
                }
            }
        }
    }

    return dp[sLen][pLen]
}