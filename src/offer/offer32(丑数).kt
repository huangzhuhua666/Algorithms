package offer

import kotlin.math.min

/**
 * Create by hzh on 2020/5/18.
 * 丑数
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
fun main() {
    println(getUglyNumber(18))
    println(getUglyNumber(20))
}

/**
 * 1 2 3 4 5 6 8 9 10 12 15 16 18 20 24 25 27 30 32 36
 *
 * 一个丑数是由前面某一个丑数乘2、乘3或乘5得到的
 */
private fun getUglyNumber(index: Int): Int = if (index < 1) 0
else {
    val array = IntArray(index) { if (it == 0) 1 else 0 }

    var mul2 = 0
    var mul3 = 0
    var mul5 = 0

    for (next in 1 until index) {
        array[next] = min(array[mul2] * 2, min(array[mul3] * 3, array[mul5] * 5))

        if (array[mul2] * 2 == array[next]) ++mul2

        if (array[mul3] * 3 == array[next]) ++mul3

        if (array[mul5] * 5 == array[next]) ++mul5
    }

    array.last()
}