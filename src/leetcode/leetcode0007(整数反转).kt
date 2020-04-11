package leetcode

/**
 * Create by hzh on 2020/4/11.
 * 整数反转
 *
 * 给出一个32位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
fun main() {
    println(reverse(1534236469))
}

private fun reverse(x: Int): Int {
    var num = x

    var newNum = 0
    while (num != 0) {
        val pop = num % 10
        num /= 10

        if (newNum > Int.MAX_VALUE / 10 || (newNum == Int.MAX_VALUE / 10 && pop > 7)) return 0
        if (newNum < Int.MIN_VALUE / 10 || (newNum == Int.MIN_VALUE / 10 && pop < -8)) return 0

        newNum = 10 * newNum + pop
    }

    return newNum
}