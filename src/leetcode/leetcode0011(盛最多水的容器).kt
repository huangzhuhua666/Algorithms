package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * Create by hzh on 2020/4/13.
 * 盛最多水的容器
 *
 * 给你n个非负整数a1，a2，...，an，每个数代表坐标中的一个点(i, ai)。
 * 在坐标内画n条垂直线，垂直线i的两个端点分别为(i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且n的值至少为2。
 */
fun main() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}

/**
 * 双下标，不解释
 */
private fun maxArea(height: IntArray): Int = when (height.size < 2) {
    true -> 0
    false -> when (height.size == 2) {
        true -> min(height[0], height[1])
        false -> {
            var result = Int.MIN_VALUE
            var left = 0
            var right = height.size - 1

            while (left < right) {
                result = max(result, min(height[left], height[right]) * (right - left))

                if (height[left] <= height[right]) ++left
                else --right
            }

            result
        }
    }
}