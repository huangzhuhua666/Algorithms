package leetcode

import kotlin.math.abs

/**
 * Create by hzh on 2024/1/30.
 * ��ӽ�������֮��
 *
 * ����һ������Ϊ n ���������� nums �� һ��Ŀ��ֵ target��
 * ����� nums ��ѡ������������ʹ���ǵĺ��� target ��ӽ���
 * �������������ĺ͡�
 * �ٶ�ÿ������ֻ����ǡ��һ���⡣
 *
 * ʾ�� 1��
 * ���룺nums = [-1,2,1,-4], target = 1
 * �����2
 * ���ͣ��� target ��ӽ��ĺ��� 2 (-1 + 2 + 1 = 2) ��
 *
 * ʾ�� 2��
 * ���룺nums = [0,0,0], target = 1
 * �����0
 */
fun main() {
    println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
    println(threeSumClosest(intArrayOf(0, 0, 0), 2))
}

/**
 * ������֮������
 */
private fun threeSumClosest(nums: IntArray, target: Int): Int {
    var result = 0
    var diff = Int.MAX_VALUE

    nums.sort()

    for (first in 0 until nums.size - 2) {
        if (first > 0 && nums[first] == nums[first - 1]) {
            continue
        }

        var second = first + 1
        var third = nums.size - 1
        while (second < third) {
            val sum = nums[first] + nums[second] + nums[third]
            val absDiff = abs(target - sum)

            when {
                sum < target -> {
                    if (absDiff < diff) {
                        diff = absDiff
                        result = sum
                    }

                    while (second < third && nums[second] == nums[++second]);
                }
                sum > target -> {
                    if (absDiff < diff) {
                        diff = absDiff
                        result = sum
                    }

                    while (second < third && nums[third] == nums[--third]);
                }
                else -> {
                    return target
                }
            }
        }
    }

    return result
}