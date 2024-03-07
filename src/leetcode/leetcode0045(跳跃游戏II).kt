package leetcode

import kotlin.math.max

/**
 * Create by hzh on 2024/3/7.
 * 跳跃游戏II
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
fun main() {
    println(jump1(intArrayOf(2, 3, 1, 1, 4)))
    println(jump1(intArrayOf(2, 3, 0, 1, 4)))
    println("---split line ---")
    println(jump2(intArrayOf(2, 3, 1, 1, 4)))
    println(jump2(intArrayOf(2, 3, 0, 1, 4)))
}

/**
 * 反向查找出发位置
 *
 * 贪心地选择距离最后一个位置最远的那个位置，也就是对应下标最小的那个位置。
 * 因此，我们可以从左到右遍历数组，选择第一个满足要求的位置。
 * 找到最后一步跳跃前所在的位置之后，我们继续贪心地寻找倒数第二步跳跃前所在的位置，
 * 以此类推，直到找到数组的开始位置。
 */
private fun jump1(nums: IntArray): Int {
    var step = 0
    var position = nums.lastIndex

    while (position > 0) {
        for (i in 0 until position) {
            if (nums[i] + i >= position) {
                position = i
                ++step
                break
            }
        }
    }

    return step
}

private fun jump2(nums: IntArray): Int {
    var step = 0

    var maxPosition = 0
    var end = 0
    for (i in 0 until nums.lastIndex) {
        maxPosition = max(maxPosition, i + nums[i])

        if (i == end) {
            end = maxPosition
            ++step
        }
    }

    return step
}