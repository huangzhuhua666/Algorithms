package leetcode

/**
 * Create by hzh on 2024/2/1.
 * ����֮��
 *
 * ����һ���� n ��������ɵ����� nums ����һ��Ŀ��ֵ target ��
 * �����ҳ���������������ȫ�������Ҳ��ظ�����Ԫ�� [nums[a], nums[b], nums[c], nums[d]]
 * ����������Ԫ��Ԫ��һһ��Ӧ������Ϊ������Ԫ���ظ�����
 * 0 <= a, b, c, d < n
 * a��b��c �� d ������ͬ
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * ����԰� ����˳�� ���ش� ��
 *
 * ʾ�� 1��
 * ���룺nums = [1,0,-1,0,-2,2], target = 0
 * �����[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * ʾ�� 2��
 * ���룺nums = [2,2,2,2,2], target = 8
 * �����[[2,2,2,2]]
 *
 * ��ʾ��
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 */
fun main() {
    println(fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
    println(fourSum(intArrayOf(2, 2, 2, 2), 8))
    println(fourSum(intArrayOf(1, 0, -1, 0, -2, 2, -2, 4, 3), 0))
    println(fourSum(intArrayOf(2, 2, 2, 2, 2), 8))
    println(fourSum(intArrayOf(-2, -1, -1, 1, 1, 2, 2), 0))
    println(fourSum(intArrayOf(1000000000, 1000000000, 1000000000, 1000000000), -294967296))
}

/**
 * �ټ�һ��ѭ��������֮��
 */
private fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) {
        return emptyList()
    }

    val result = mutableListOf<List<Int>>()

    nums.sort()

    for (first in 0 until nums.size - 3) {
        if (first > 0 && nums[first] == nums[first - 1]) {
            continue
        }

        for (second in first + 1 until nums.size - 2) {
            if (second > first + 1 && nums[second] == nums[second - 1]) {
                continue
            }

            var third = second + 1
            var fourth = nums.size - 1

            while (third < fourth) {
                val sum = nums[first].toLong() + nums[second] + nums[third] + nums[fourth]

                when {
                    sum < target -> {
                        while (third < fourth && nums[third] == nums[++third]);
                    }
                    sum > target -> {
                        while (third < fourth && nums[fourth] == nums[--fourth]);
                    }
                    else -> {
                        result.add(listOf(nums[first], nums[second], nums[third], nums[fourth]))
                        while (third < fourth && nums[third] == nums[++third]);
                        while (third < fourth && nums[fourth] == nums[--fourth]);
                    }
                }
            }
        }
    }

    return result
}