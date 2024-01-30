package leetcode

import kotlin.math.abs

/**
 * Create by hzh on 2024/1/30.
 * 最接近的三数之和
 *
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 *
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 */
fun main() {
    println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
    println(threeSumClosest(intArrayOf(0, 0, 0), 2))
}

/**
 * 与三数之和相似
 */
private fun threeSumClosest(nums: IntArray, target: Int): Int {
    var result = 0
    var diff = Int.MAX_VALUE

    nums.sort()

    for (first in 0 until nums.size - 2) {
        if (first > 0 && nums[first] == nums[first - 1]) {
            continue
        }

        var second = first + 1
        var third = nums.size - 1
        while (second < third) {
            val sum = nums[first] + nums[second] + nums[third]
            val absDiff = abs(target - sum)

            when {
                sum < target -> {
                    if (absDiff < diff) {
                        diff = absDiff
                        result = sum
                    }

                    while (second < third && nums[second] == nums[++second]);
                }
                sum > target -> {
                    if (absDiff < diff) {
                        diff = absDiff
                        result = sum
                    }

                    while (second < third && nums[third] == nums[--third]);
                }
                else -> {
                    return target
                }
            }
        }
    }

    return result
}