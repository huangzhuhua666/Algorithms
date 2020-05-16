package offer

import kotlin.math.max
import kotlin.math.min

/**
 * Create by hzh on 2020/5/16.
 * 整数中1出现的次数
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1到 n中1出现的次数）。
 */
fun main() {
    println(numberOf1Between1AndN(13))
}

/**
 * 个位的1每隔10出现1次：
 * k = n % 10
 * n / 10  + if (k > 1) 1 else if(k < 1) 0 else k - 1 + 1
 *
 * 十位的1每隔100出现10次：
 * k = n % 100
 * n / 100 * 10 + if (k > 19) 10 else if (k < 10) 0 else k - 10 + 1
 *
 * 百位的1每隔1000出现100次：
 * k = n % 100
 * n / 1000 * 100 + if(k > 199) 100 else if(k < 100) 0 else k - 100 + 1
 * 依次类推
 *
 * 可归纳出：
 * i = 1、10、100、1000……
 * k = n % (i * 10)
 * count(i) = n / (i * 10) * i + if (k > 2 * i - 1) i else if (k < i) 0 else k - i + 1
 * sum = sum(count(i))
 *
 * 对k - i + 1，只需要保证它在[0, i]区间内即可，所以有
 * count(i) = n / (i * 10) * i + min(i, max(0, k - i + 1))
 */
private fun numberOf1Between1AndN(n: Int): Int = if (n <= 0) 0
else {
    var count = 0

    var i = 1
    while (i <= n) {
        val divider = i * 10
        val k = n % divider

        count += n / divider * i + min(i, max(0, k - i + 1))

        i *= 10
    }

    count
}