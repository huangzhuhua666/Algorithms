package offer

import kotlin.math.max

/**
 * Create by hzh on 2020/4/30.
 * 连续子数组的最大和
 *
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和。
 */
fun main() {
    println(findGreatestSumOfSubArray(intArrayOf(6, -3, -2, 7, -15, 1, 2, 2)))
}

/**
 * 动态规划
 */
private fun findGreatestSumOfSubArray(array: IntArray): Int = if (array.isEmpty()) 0
else {
    var result = array[0] // 记录当前所有子数组的和的最大值
    var subArrayMax = array[0] // 包含array[i]的连续数组最大值

    for (i in 1..array.lastIndex) {
        subArrayMax = max(subArrayMax + array[i], array[i])
        result = max(result, subArrayMax)
    }

    result
}