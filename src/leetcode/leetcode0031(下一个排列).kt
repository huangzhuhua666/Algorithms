package leetcode

/**
 * Create by hzh on 2024/2/22.
 * 下一个排列
 *
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 */
fun main() {
    println(nextPermutation(intArrayOf(1, 2, 3)).toList())
    println(nextPermutation(intArrayOf(3, 2, 1)).toList())
    println(nextPermutation(intArrayOf(1, 1, 5)).toList())
    println(nextPermutation(intArrayOf(1, 3, 2)).toList())
    println(nextPermutation(intArrayOf(1, 5, 1)).toList())
    println(nextPermutation(intArrayOf(5, 1, 1)).toList())
    println(nextPermutation(intArrayOf(5, 4, 7, 5, 3, 2)).toList())
}

private fun nextPermutation(nums: IntArray): IntArray {
    nextPermutation1(nums)
    return nums
}

private fun nextPermutation1(nums: IntArray) {
    if (nums.isEmpty() || nums.size == 1) {
        return
    }
    if (nums.size == 2) {
        // 数组长度为 2，直接交换两个值
        swap(nums, 0, 1)
        return
    }

    val end = nums.size - 1
    // 从后面往前面查找
    for (i in end downTo 1) {
        // 如果后一个数比前一个数小，前移
        if (nums[i] <= nums[i - 1]) {
            // 如果已经轮询到数组第二个元素了，说明这个数组是完全降序排列的，直接翻转数组
            if (i == 1) {
                reverseNums(nums, 0, end)
                break
            } else {
                continue
            }
        }

        // 找到第一个元素使得他的前一个元素使小于它的，例如[5, 4, 7, 5, 3, 2]的7，它的前一个元素是4
        for (j in end downTo i) {
            // 再次从后面查找，直到当前元素的位置，找出第一个比它前一个元素大的
            if (nums[j] <= nums[i - 1]) {
                continue
            }

            // 交换这两个元素，则变成[5, 5, 7, 4, 3, 2]
            swap(nums, i - 1, j)
            break
        }

        // 交换后，i ~ end 这一部分必然是降序的，直接翻转数组
        reverseNums(nums, i, end)
        break
    }
}

private fun swap(nums: IntArray, index1: Int, index2: Int) {
    val temp = nums[index1]
    nums[index1] = nums[index2]
    nums[index2] = temp
}

private fun reverseNums(nums: IntArray, start: Int, end: Int) {
    val len = end - start + 1
    for (i in 0 until len / 2) {
        swap(nums, i + start, len - i - 1 + start)
    }
}