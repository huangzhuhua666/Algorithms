/**
 * Create by hzh on 2020/1/14.
 */
/**
 * 绳子长度对应的价格
 */
private val PRICE = intArrayOf(1, 5, 8, 9, 10, 17, 17, 20, 24, 30)

fun main() {
    println("result -> ${cutRod(7)}")
}

/**
 * 给定一段大小的绳子，求怎么切可以最大化利润
 * @param length 绳子长度
 * @return 最大利润
 */
private fun cutRod(length: Int): Int {
    val result = IntArray(length + 1) { 0 }

    for (i in 1..length) {
        var max = -Int.MAX_VALUE
        for (j in 1..i) {
            // 分解成若干个子问题
            (PRICE[j - 1] + result[i - j]).let { if (max < it) max = it }
        }
        result[i] = max
    }

    return result[length]
}