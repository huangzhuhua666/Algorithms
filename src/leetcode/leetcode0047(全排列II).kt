package leetcode

/**
 * Create by hzh on 2024/3/7.
 * 全排列II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：[[1,1,2],[1,2,1],[2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
fun main() {
    println(permuteUnique(intArrayOf(1, 1, 2)))
    println(permuteUnique(intArrayOf(1, 2, 3)))
    println(permuteUnique(intArrayOf(2, 2, 1, 1)))
}

private fun permuteUnique(nums: IntArray): List<List<Int>> {
    nums.sort()

    val result = mutableListOf<List<Int>>()
    val path = mutableListOf<Int>()
    val used = BooleanArray(nums.size)
    backtrack(nums, used, path, result)
    return result
}

private fun backtrack(
        nums: IntArray,
        used: BooleanArray,
        path: MutableList<Int>,
        result: MutableList<List<Int>>
) {
    if (path.size == nums.size) {
        result.add(path.toList())
        return
    }

    for (i in nums.indices) {
        if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
            continue
        }

        used[i] = true
        path.add(nums[i])
        backtrack(nums, used, path, result)
        used[i] = false
        path.removeAt(path.lastIndex)
    }
}