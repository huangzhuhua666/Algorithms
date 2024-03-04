package leetcode

/**
 * Create by hzh on 2024/3/4.
 * ȱʧ�ĵ�һ������
 *
 * ����һ��δ������������� nums �������ҳ�����û�г��ֵ���С����������
 * ����ʵ��ʱ�临�Ӷ�Ϊ O(n) ����ֻʹ�ó����������ռ�Ľ��������
 *
 * ʾ�� 1��
 * ���룺nums = [1,2,0]
 * �����3
 *
 * ʾ�� 2��
 * ���룺nums = [3,4,-1,1]
 * �����2
 *
 * ʾ�� 3��
 * ���룺nums = [7,8,9,11,12]
 * �����1
 */
fun main() {
    println(firstMissingPositive(intArrayOf(1, 2, 0)))
    println(firstMissingPositive(intArrayOf(3, 4, -1, 1)))
    println(firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
    println(firstMissingPositive(intArrayOf(1, 2, 3, 5, 6, 7)))
}

private fun firstMissingPositive(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 1
    }

    for (i in nums.indices) {
        while (nums[i] in 1..nums.size && nums[i] != nums[nums[i] - 1]) {
            swap(nums, i, nums[i] - 1)
        }
    }

    for (i in nums.indices) {
        if (nums[i] - 1 != i) {
            return i + 1
        }
    }

    return nums.size + 1
}

private fun swap(nums: IntArray, index1: Int, index2: Int) {
    val temp = nums[index1]
    nums[index1] = nums[index2]
    nums[index2] = temp
}