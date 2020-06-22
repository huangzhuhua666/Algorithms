package offer

import kotlin.math.abs

/**
 * Create by hzh on 2020/5/30.
 * 数字在排序数组中出现的次数
 *
 * 统计一个数字在排序数组中出现的次数。
 */
fun main() {
    println(getNumberOfK(intArrayOf(0, 2, 3, 3, 3, 3, 3, 6, 7, 8), 3))
}

private fun getNumberOfK(array: IntArray, k: Int): Int = if (array.isEmpty()) 0
else abs(binarySearch(array, k + .5) - binarySearch(array, k - .5))

/**
 * 方法一
 * 数组是整数，只要用二分查找找出k + 0.5和k - 0.5在数组中的出入位置，相减即可
 */
private fun binarySearch(array: IntArray, num: Double): Int {
    var low = 0
    var high = array.lastIndex
    while (low <= high) {
        val mid = (low + high) / 2

        if (array[mid] > num) high = mid - 1
        else low = mid + 1
    }

    return low
}