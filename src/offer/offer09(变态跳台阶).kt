package offer

/**
 * Create by hzh on 2020/3/25.
 * 变态跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
fun main() {
    println(jumpFloorII(5))
}

/**
 * 2 ^ (target - 1)
 */
private fun jumpFloorII(target: Int): Int = if (target == 0) 0
else 1 shl target - 1