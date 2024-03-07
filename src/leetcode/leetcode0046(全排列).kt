package leetcode

/**
 * Create by hzh on 2024/3/7.
 * 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 */
fun main() {
    println(permute(intArrayOf(1, 2, 3)))
    println(permute(intArrayOf(0, 1)))
    println(permute(intArrayOf(1)))
}

private fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtrack(nums, 0, result)
    return result
}

private fun backtrack(nums: IntArray, index: Int, result: MutableList<List<Int>>) {
    if (index == nums.lastIndex) {
        result.add(nums.toList())
        return
    }

    for (i in index..nums.lastIndex) {
        swap(nums, i, index)
        backtrack(nums, index + 1, result)
        swap(nums, i, index)
    }
}

private fun swap(nums: IntArray, index1: Int, index2: Int) {
    if (index1 == index2) {
        return
    }

    val temp = nums[index1]
    nums[index1] = nums[index2]
    nums[index2] = temp
}