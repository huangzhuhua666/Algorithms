package leetcode

/**
 * Create by hzh on 2024/2/27.
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
fun main() {
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).toList())
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).toList())
    println(searchRange(intArrayOf(), 0).toList())
}

private fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) {
        return intArrayOf(-1, -1)
    }

    val left = binarySearch(nums, target, true)
    val right = binarySearch(nums, target, false) - 1
    if (left <= right && right < nums.size && nums[left] == target && nums[right] == target) {
        return intArrayOf(left, right)
    }

    return intArrayOf(-1, -1)
}

private fun binarySearch(nums: IntArray, target: Int, isFindLeft: Boolean): Int {
    var left = 0
    var right = nums.size - 1
    var result = nums.size
    while (left <= right) {
        val mid = (left + right) / 2
        if (nums[mid] > target || (isFindLeft && nums[mid] >= target)) {
            right = mid - 1
            result = mid
        } else {
            left = mid + 1
        }
    }

    return result
}