package nowcoder

/**
 * Create by hzh on 2020/3/25.
 * 跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
fun main() {
    println(jumpFloor1(5))
    println(jumpFloor2(5))
}

/**
 * 斐波那契解法
 */

private fun jumpFloor1(target: Int): Int = if (target <= 3) target
else {
    val result = IntArray(target + 1) {
        if (it <= 3) it
        else 0
    }

    for (i in 4..target) {
        result[i] = result[i - 1] + result[i - 2]
    }

    result[target]
}

private fun jumpFloor2(target: Int): Int = if (target <= 3) target
else jumpFloor2(target - 1) + jumpFloor2(target - 2)