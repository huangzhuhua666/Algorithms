package nowcoder

/**
 * Create by hzh on 2020/3/25.
 * ��ֵ�������η�
 *
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * ��֤base��exponent��ͬʱΪ0��
 */
fun main() {
    println(power(2.0, 7))
}

private fun power(base: Double, exponent: Int): Double = if (base == 0.0 && exponent == 0) 0.0
else if (base == 0.0) 0.0
else if (exponent < 0) 1.0 / powerCore(base, -exponent) // exponentС��0
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
            true -> { // ����
                val subResult = powerCore(base, exponent - 1 shr 1)
                base * subResult * subResult
            }
            false -> { // ż��
                val subResult = powerCore(base, exponent shr 1)
                subResult * subResult
            }
        }
    }
}