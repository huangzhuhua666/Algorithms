package leetcode

/**
 * Create by hzh on 2024/1/24.
 * 三数之和
 *
 * 给你一个整数数组 nums ，判断是否存在三元组
 * [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum(intArrayOf(0, 0, 0)))
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4)))

    println(threeSum1(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum1(intArrayOf(0, 0, 0)))
    println(threeSum1(intArrayOf(-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4)))
}

/**
 * 固定一个数，对剩余的差值用两数之和的方法。（时间超长，要排序和去重，淦）
 */
private fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableSetOf<List<Int>>()

    nums.forEachIndexed { index, i ->
        result.addAll(twoSum(nums, index, 0 - i))
    }

    return result.toList()
}

private fun twoSum(nums: IntArray, currIndex: Int, target: Int): Set<List<Int>> {
    val result = mutableSetOf<List<Int>>()
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        if (i == currIndex) {
            continue
        }

        if (map.containsKey(target - nums[i])) {
            result.add(listOf(0 - target, nums[i], target - nums[i]).sorted())
        } else {
            map[nums[i]] = i
        }
    }

    return result
}

/**
 * 排序 + 双指针
 */
private fun threeSum1(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    nums.sort()

    for (first in 0 until nums.size - 2) {
        if (nums[first] > 0) {
            // 第一个元素大于0，那么排序后的数组，他后面的元素都大于0，所以和不可能为0了，直接跳出
            break
        }

        if (first > 0 && nums[first] == nums[first - 1]) {
            // 跳过该元素，因为和前一个元素相同则前一个元素已经将所有组合都加入结果了，再搜索只会得到重复的元素，跳过
            continue
        }

        var second = first + 1
        var third = nums.size - 1
        while (second < third) {
            val sum = nums[first] + nums[second] + nums[third]

            when {
                sum < 0 -> {
                    // 和小于0，往右搜索，并跳过相同的元素
                    while (second < third && nums[second] == nums[++second]);
                }
                sum > 0 -> {
                    // 和大于0，往左搜索，并跳过相同的元素
                    while (second < third && nums[third] == nums[--third]);
                }
                else -> {
                    // 和为0，记录结果，并且左右指针向中间收缩，跳过相同的元素
                    result.add(listOf(nums[first], nums[second], nums[third]))
                    while (second < third && nums[second] == nums[++second]);
                    while (second < third && nums[third] == nums[--third]);
                }
            }
        }
    }

    return result
}