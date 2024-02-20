package leetcode

import kotlin.math.abs

/**
 * Create by hzh on 2024/2/20.
 * 两数相除
 *
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 *
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [?2^31,  2^31 ? 1] 。
 * 本题中，如果商 严格大于 2^31 ? 1 ，则返回 2^31 ? 1 ；如果商 严格小于 -2^31 ，则返回 -2^31 。
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 */
fun main() {
    println(divide(10, 3))
    println(divide(7, -3))
    println(divide(-2147483648, 1))
}

/**
 * 商×除数+余数=被除数
 * 我们可以把一个dividend（被除数）先除以2^n，n最初为31，不断减小n去试探,当某个n满足dividend/2^n>=divisor时，
 *
 * 表示我们找到了一个足够大的数，这个数*divisor是不大于dividend的，所以我们就可以减去2^n个divisor，以此类推
 *
 * 我们可以以100/3为例
 *
 * 2^n是1，2，4，8...2^31这种数，当n为31时，这个数特别大，100/2^n是一个很小的数，肯定是小于3的，所以循环下来，
 *
 * 当n=5时，100/32=3, 刚好是大于等于3的，这时我们将100-32*3=4，也就是减去了32个3，接下来我们再处理4，同样手法可以再减去一个3
 *
 * 所以一共是减去了33个3，所以商就是33
 */
private fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == 0) {
        return 0
    }

    if (dividend == Int.MIN_VALUE && divisor == -1) {
        return Int.MAX_VALUE
    }

    // 符号是否相反
    val isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)
    var newDividend = abs(dividend.toLong())
    val newDivisor = abs(divisor.toLong())

    var result = 0
    for (i in 31 downTo 0) {
        // 找出足够大的数 2^n * divisor
        if ((newDividend shr i) >= newDivisor) {
            // 将结果加上2^n
            result += 1 shl i
            // 将被除数减去 2^n * divisor
            newDividend -= newDivisor shl i
        }
    }

    return if (isNegative) {
        -result
    } else {
        result
    }
}