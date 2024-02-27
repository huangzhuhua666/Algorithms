package leetcode

/**
 * Create by hzh on 2024/2/27.
 * ��������λ��
 *
 * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ����������������
 * ���Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
 * �����ʹ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��
 *
 * ʾ�� 1:
 * ����: nums = [1,3,5,6], target = 5
 * ���: 2
 *
 * ʾ�� 2:
 * ����: nums = [1,3,5,6], target = 2
 * ���: 1
 *
 * ʾ�� 3:
 * ����: nums = [1,3,5,6], target = 7
 * ���: 4
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