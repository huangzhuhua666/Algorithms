package nowcoder

/**
 * Create by hzh on 2020/3/25.
 * 数值的整数次方
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0。
 */
fun main() {
    println(power(2.0, 7))
}

private fun power(base: Double, exponent: Int): Double = if (base == 0.0 && exponent == 0) 0.0
else if (base == 0.0) 0.0
else if (exponent < 0) 1.0 / powerCore(base, -exponent) // exponent小于0
else powerCore(base, exponent)

/**
 * 2 ^ 4 = 2 ^ 2 * 2 ^ 2
 * 2 ^ 5 = 2 * 2 ^ 2 * 2 ^ 2
 */
private fun powerCore(base: Double, exponent: Int): Double = when (exponent) {
    0 -> 0.0
    1 -> base
    2 -> base * base
    else -> {
        when (exponent and 1 == 1) {
            true -> { // 奇数
                val subResult = powerCore(base, exponent - 1 shr 1)
                base * subResult * subResult
            }
            false -> { // 偶数
                val subResult = powerCore(base, exponent shr 1)
                subResult * subResult
            }
        }
    }
}