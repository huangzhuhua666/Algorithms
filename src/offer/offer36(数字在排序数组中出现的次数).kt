package offer

import kotlin.math.abs

/**
 * Create by hzh on 2020/5/30.
 * ���������������г��ֵĴ���
 *
 * ͳ��һ�����������������г��ֵĴ�����
 */
fun main() {
    println(getNumberOfK(intArrayOf(0, 2, 3, 3, 3, 3, 3, 6, 7, 8), 3))
}

private fun getNumberOfK(array: IntArray, k: Int): Int = if (array.isEmpty()) 0
else abs(binarySearch(array, k + .5) - binarySearch(array, k - .5))

/**
 * ����һ
 * ������������ֻҪ�ö��ֲ����ҳ�k + 0.5��k - 0.5�������еĳ���λ�ã��������
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