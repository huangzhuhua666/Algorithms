package leetcode

/**
 * Create by hzh on 2024/2/27.
 * �����������в���Ԫ�صĵ�һ�������һ��λ��
 *
 * ����һ�����շǵݼ�˳�����е��������� nums����һ��Ŀ��ֵ target�������ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 * ��������в�����Ŀ��ֵ target������ [-1, -1]��
 * �������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��������⡣
 *
 * ʾ�� 1��
 * ���룺nums = [5,7,7,8,8,10], target = 8
 * �����[3,4]
 *
 * ʾ�� 2��
 * ���룺nums = [5,7,7,8,8,10], target = 6
 * �����[-1,-1]
 *
 * ʾ�� 3��
 * ���룺nums = [], target = 0
 * �����[-1,-1]
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