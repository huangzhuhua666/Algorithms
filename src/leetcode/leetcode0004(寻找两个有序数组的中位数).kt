package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * Create by hzh on 2020/4/10.
 * 寻找两个有序数组的中位数
 *
 * 给定两个大小为m和n的有序数组nums1和nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为O(log(m + n))。
 * 你可以假设nums1和nums2不会同时为空。
 */
fun main() {
    println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4, 5, 6)))
}

/**
 * 将数组A分成两半A[0] A[1] A[2]...A[i - 1]  |  A[i] A[i + 1] A[i + 2]...A[m - 1]
 * 将数组B分成两半B[0] B[1] B[2]...B[j - 1]  |  B[j] B[j + 1] B[j + 2]...B[n - 1]
 *
 * 把数组A和数组B的前半部分当作left_part，后半部分当作right_part。
 * 由中位数的定义得到：
 * len(left_part) = len(right_part)，且max(left_part) < min(right_part)。
 *
 * 需要保证：
 * 1.i + j = m - i + n - j 或 i + j = m - i + n - j + 1
 * 2.B[j - 1] <= A[i]以及A[i - 1] <= B[j]
 *
 * 接下来进行二叉树搜索：
 * 1.令iMin = 0，iMax = m，在[iMin,iMax]中搜索
 * 2.令i = (iMin + iMax) / 2，j = (m + n + 1) / 2 - i
 * 3.若B[j - 1] > A[i]，意味着A[i]太小，应当增大i，调整搜索范围为[i + 1, iMax]，即使iMin = i + 1
 *   若A[i - 1] > B[j]，意味着A[i - 1]太大，应当减小i，调整搜索范围为[iMin, i - 1]，即使iMax = i - 1
 *   若B[j - 1] <= A[i]且A[i - 1] <= B[j]，则找到目标对象，停止搜索
 */
private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var m = nums1.size
    var n = nums2.size
    var array1 = nums1
    var array2 = nums2

    if (m > n) { // 确保 j = (m + n + 1) - i > 0
        val tmp = array1
        array1 = array2
        array2 = tmp

        m = array1.size
        n = array2.size
    }

    var iMin = 0
    var iMax = m
    val halfLen = (m + n + 1) / 2

    while (iMin <= iMax) {
        val i = (iMin + iMax) / 2
        val j = halfLen - i

        // B[j - 1] > A[i]，A[i]太小，增大i，调整搜索范围为[i + 1, iMax]，即使iMin = i + 1
        if (i < iMax && array2[j - 1] > array1[i]) iMin = i + 1
        // A[i - 1] > B[j]，A[i - 1]太大，减小i，调整搜索范围为[iMin, i - 1]，即使iMax = i - 1
        else if (i > iMin && array1[i - 1] > array2[j]) iMax = i - 1
        else { // 找到目标对象，停止搜索
            val maxLeft = when (i == 0) {
                true -> array2[j - 1] // A不在left_part
                false -> {
                    if (j == 0) array1[i - 1] // B不在right_part
                    else max(array1[i - 1], array2[j - 1]) // A、B均有元素在left_part
                }
            }

            // 两个数组合并长度为奇数时，中位数落在left_part
            if ((m + n) and 1 == 1) return maxLeft.toDouble()

            // 两个数组合并长度为偶数
            val minRight = when (i == m) {
                true -> array2[j] // A不在right_part
                false -> {
                    if (j == n) array1[i] // B不在right_part
                    else min(array1[i], array2[j]) // A、B均有元素在right_part
                }
            }

            return (maxLeft + minRight) / 2.0
        }
    }

    return 0.0
}