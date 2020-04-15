package offer

/**
 * Create by hzh on 2020/3/25.
 * 二进制中1的个数
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
fun main() {
    println(numberOf1(15))
}

/**
 * 1111 & 1110 = 1110
 * 1110 & 1101 = 1100
 * 1100 & 1011 = 1000
 * 1000 & 0111 = 0
 */
private fun numberOf1(n: Int): Int {
    var number = n
    var result = 0

    while (number != 0) {
        ++result
        number = number and number - 1
    }

    return result
}