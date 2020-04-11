package leetcode

/**
 * Create by hzh on 2020/4/11.
 * 字符串转换整数 (atoi)
 *
 * 请你来实现一个atoi函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 *
 * 注意：
 * 假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
 * 则你的函数不需要进行转换，即无法进行有效转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回0。
 *
 * 提示：
 * 本题中的空白字符只包括空格字符' '。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[-2^31, 2^31 - 1]。
 * 如果数值超过这个范围，请返回INT_MAX(2^31 - 1)或INT_MIN(-2^31)。
 */
fun main() {
    println(myAtoi("42"))
    println(myAtoi("   -42"))
    println(myAtoi("4193 with words"))
    println(myAtoi("words and 987"))
    println(myAtoi("-91283472332"))
    println(myAtoi("-2147483649"))
    println(myAtoi("2147483649"))
}

private fun myAtoi(str: String): Int = if (str.trim() == "") 0
else if (!isLegalNumStar(str.trim()[0])) 0
else when (str.trim()[0]) {
    '-' -> parseNum(str.trim().substring(1), true)
    '+' -> parseNum(str.trim().substring(1), false)
    else -> parseNum(str.trim().substring(0), false)
}

/**
 * 判断是否以数字或+、-开头
 */
private fun isLegalNumStar(c: Char): Boolean = c in '0'..'9' || c == '+' || c == '-'

/**
 * 解析字符转化为数字
 */
private fun parseNum(str: String, isNegative: Boolean): Int {
    var num = 0

    for (c in str) {
        if (c !in '0'..'9') break

        val add = c.toInt() - 48
        if (isOverflow(num, add, isNegative)) return if (isNegative) Int.MIN_VALUE else Int.MAX_VALUE

        num = 10 * num + add
    }

    return if (isNegative) -num else num
}

/**
 * 是否溢出
 */
private fun isOverflow(num: Int, add: Int, isNegative: Boolean): Boolean = when (isNegative) {
    true -> -num < Int.MIN_VALUE / 10 || (-num == Int.MIN_VALUE / 10 && add > 8)
    false -> num > Int.MAX_VALUE / 10 || (num == Int.MAX_VALUE / 10 && add > 7)
}