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
    println(isMatch("aa", "a"))
    println(isMatch("aa", "a*"))
    println(isMatch("ab", ".*"))
    println(isMatch("aab", "c*a*b"))
    println(isMatch("mississippi", "mis*is*p*."))
    println(isMatch("ab", ".*c"))
}

/**
 * 回溯法
 */
private fun isMatch(s: String, p: String): Boolean = if (p.isEmpty()) s.isEmpty()
else {
    // 匹配第一个字符或'.'
    val isFirstMatch = s.isNotEmpty() && (s[0] == p[0] || p[0] == '.')

    // 如果模式串有星号，它会出现在第二个位置p[1]，
    // 此时：
    // 1.直接忽略模式串这一部分
    // 2.当模式串能匹配当前字符时，删除匹配串第一个字符
    // 当这两个条件其中一个成立时，可以被匹配
    if (p.length >= 2 && p[1] == '*')
        isMatch(s, p.substring(2))
                || (isFirstMatch && isMatch(s.substring(1), p))
    else // 无星号，匹配串和模式串同时后移，前提是模式串能匹配当前字符
        isFirstMatch && isMatch(s.substring(1), p.substring(1))
}