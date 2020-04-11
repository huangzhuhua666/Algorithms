package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * Create by hzh on 2020/4/10.
 * Ѱ�����������������λ��
 *
 * ����������СΪm��n����������nums1��nums2��
 * �����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�ΪO(log(m + n))��
 * ����Լ���nums1��nums2����ͬʱΪ�ա�
 */
fun main() {
    println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4, 5, 6)))
}

/**
 * ������A�ֳ�����A[0] A[1] A[2]...A[i - 1]  |  A[i] A[i + 1] A[i + 2]...A[m - 1]
 * ������B�ֳ�����B[0] B[1] B[2]...B[j - 1]  |  B[j] B[j + 1] B[j + 2]...B[n - 1]
 *
 * ������A������B��ǰ�벿�ֵ���left_part����벿�ֵ���right_part��
 * ����λ���Ķ���õ���
 * len(left_part) = len(right_part)����max(left_part) < min(right_part)��
 *
 * ��Ҫ��֤��
 * 1.i + j = m - i + n - j �� i + j = m - i + n - j + 1
 * 2.B[j - 1] <= A[i]�Լ�A[i - 1] <= B[j]
 *
 * ���������ж�����������
 * 1.��iMin = 0��iMax = m����[iMin,iMax]������
 * 2.��i = (iMin + iMax) / 2��j = (m + n + 1) / 2 - i
 * 3.��B[j - 1] > A[i]����ζ��A[i]̫С��Ӧ������i������������ΧΪ[i + 1, iMax]����ʹiMin = i + 1
 *   ��A[i - 1] > B[j]����ζ��A[i - 1]̫��Ӧ����Сi������������ΧΪ[iMin, i - 1]����ʹiMax = i - 1
 *   ��B[j - 1] <= A[i]��A[i - 1] <= B[j]�����ҵ�Ŀ�����ֹͣ����
 */
private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var m = nums1.size
    var n = nums2.size
    var array1 = nums1
    var array2 = nums2

    if (m > n) { // ȷ�� j = (m + n + 1) - i > 0
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

        // B[j - 1] > A[i]��A[i]̫С������i������������ΧΪ[i + 1, iMax]����ʹiMin = i + 1
        if (i < iMax && array2[j - 1] > array1[i]) iMin = i + 1
        // A[i - 1] > B[j]��A[i - 1]̫�󣬼�Сi������������ΧΪ[iMin, i - 1]����ʹiMax = i - 1
        else if (i > iMin && array1[i - 1] > array2[j]) iMax = i - 1
        else { // �ҵ�Ŀ�����ֹͣ����
            val maxLeft = when (i == 0) {
                true -> array2[j - 1] // A����left_part
                false -> {
                    if (j == 0) array1[i - 1] // B����right_part
                    else max(array1[i - 1], array2[j - 1]) // A��B����Ԫ����left_part
                }
            }

            // ��������ϲ�����Ϊ����ʱ����λ������left_part
            if ((m + n) and 1 == 1) return maxLeft.toDouble()

            // ��������ϲ�����Ϊż��
            val minRight = when (i == m) {
                true -> array2[j] // A����right_part
                false -> {
                    if (j == n) array1[i] // B����right_part
                    else min(array1[i], array2[j]) // A��B����Ԫ����right_part
                }
            }

            return (maxLeft + minRight) / 2.0
        }
    }

    return 0.0
}