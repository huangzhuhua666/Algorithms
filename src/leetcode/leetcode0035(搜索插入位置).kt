package leetcode

/**
 * Create by hzh on 2024/2/27.
 * 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
fun main() {
    println(searchInsert(intArrayOf(1, 3, 5, 6), 5))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 7))
}

private fun searchInsert(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) {
        return 0
    }

    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        when {
            nums[mid] < target -> left = mid + 1
            nums[mid] > target -> right = mid - 1
            else -> return mid
        }
    }

    return left
}