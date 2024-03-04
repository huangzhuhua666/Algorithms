package leetcode

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * Create by hzh on 2024/3/4.
 * 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，
 * 在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
fun main() {
    println(trap1(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap1(intArrayOf(4, 2, 0, 3, 2, 5)))

    println(trap2(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap2(intArrayOf(4, 2, 0, 3, 2, 5)))

    println(trap3(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap3(intArrayOf(4, 2, 0, 3, 2, 5)))
}

/**
 * 动态规划，每根柱子能接的雨水量取决于左右两边柱子的高度 min(leftMax, rightMax)
 */
private fun trap1(height: IntArray): Int {
    var result = 0

    val size = height.size

    // 从左到右遍历，找出每个柱子的左边柱子最大值
    var leftMax = 0
    val leftMaxArr = IntArray(size)
    height.forEachIndexed { index, num ->
        leftMax = max(leftMax, num)
        leftMaxArr[index] = leftMax
    }

    // 从右到左遍历，找出每个柱子的右边柱子的最大值
    var rightMax = 0
    val rightMaxArr = IntArray(size)
    for (index in size - 1 downTo 0) {
        val num = height[index]
        rightMax = max(rightMax, num)
        rightMaxArr[index] = rightMax
    }

    // 当前柱子能接的雨水量取决于 min(leftMax, rightMax)，还有他自己本身的高度
    height.forEachIndexed { index, num ->
        result += min(leftMaxArr[index], rightMaxArr[index]) - num
    }

    return result
}

/**
 * 单调栈
 */
private fun trap2(height: IntArray): Int {
    var result = 0

    val stack = Stack<Int>()
    height.forEachIndexed { index, num ->
        while (!stack.isEmpty() && num > height[stack.peek()]) {
            val top = stack.pop()
            if (stack.isEmpty()) {
                break
            }

            val distance = index - stack.peek() - 1
            val bound = min(num, height[stack.peek()]) - height[top]
            result += bound * distance
        }

        stack.push(index)
    }

    return result
}

/**
 * 左右双指针
 */
private fun trap3(height: IntArray): Int {
    var result = 0
    var left = 0
    var leftMax = 0
    var right = height.size - 1
    var rightMax = 0

    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] > leftMax) {
                leftMax = height[left]
            } else {
                result += leftMax - height[left]
            }

            ++left
        } else {
            if (height[right] > rightMax) {
                rightMax = height[right]
            } else {
                result += rightMax - height[right]
            }

            --right
        }
    }

    return result
}