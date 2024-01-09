package leetcode

/**
 * Create by hzh on 2022/08/11.
 */
fun main() {
    countBits(3).forEach { print("$it\t") }
    println()
    countBits(7).forEach { print("$it\t") }
    println()
    countBits(15).forEach { print("$it\t") }
}

private fun countBits(n: Int): IntArray {
    if (n == 0) return intArrayOf(0)
    if (n == 1) return intArrayOf(0, 1)

    val array = IntArray(n + 1)
    array[0] = 0
    array[1] = 1

    var highBit = 1
    for (i in 2..n) {
        if (i == highBit * 2) {
            array[i] = 1
            highBit *= 2
        } else {
            array[i] = array[i - highBit] + 1
        }
    }

    return array
}