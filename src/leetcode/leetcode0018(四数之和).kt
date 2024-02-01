package leetcode

/**
 * Create by hzh on 2024/2/1.
 * 四数之和
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 * 提示：
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 */
fun main() {
    println(fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
    println(fourSum(intArrayOf(2, 2, 2, 2), 8))
    println(fourSum(intArrayOf(1, 0, -1, 0, -2, 2, -2, 4, 3), 0))
    println(fourSum(intArrayOf(2, 2, 2, 2, 2), 8))
    println(fourSum(intArrayOf(-2, -1, -1, 1, 1, 2, 2), 0))
    println(fourSum(intArrayOf(1000000000, 1000000000, 1000000000, 1000000000), -294967296))
}

/**
 * 再加一层循环的三数之和
 */
private fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) {
        return emptyList()
    }

    val result = mutableListOf<List<Int>>()

    nums.sort()

    for (first in 0 until nums.size - 3) {
        if (first > 0 && nums[first] == nums[first - 1]) {
            continue
        }

        for (second in first + 1 until nums.size - 2) {
            if (second > first + 1 && nums[second] == nums[second - 1]) {
                continue
            }

            var third = second + 1
            var fourth = nums.size - 1

            while (third < fourth) {
                val sum = nums[first].toLong() + nums[second] + nums[third] + nums[fourth]

                when {
                    sum < target -> {
                        while (third < fourth && nums[third] == nums[++third]);
                    }
                    sum > target -> {
                        while (third < fourth && nums[fourth] == nums[--fourth]);
                    }
                    else -> {
                        result.add(listOf(nums[first], nums[second], nums[third], nums[fourth]))
                        while (third < fourth && nums[third] == nums[++third]);
                        while (third < fourth && nums[fourth] == nums[--fourth]);
                    }
                }
            }
        }
    }

    return result
}