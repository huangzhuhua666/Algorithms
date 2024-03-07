package leetcode

import kotlin.math.max

/**
 * Create by hzh on 2024/3/7.
 * ��Ծ��ϷII
 *
 * ����һ������Ϊ n �� 0 ������������ nums����ʼλ��Ϊ nums[0]��
 * ÿ��Ԫ�� nums[i] ��ʾ������ i ��ǰ��ת����󳤶ȡ�
 * ���仰˵��������� nums[i] �����������ת������ nums[i + j] ��:
 * 0 <= j <= nums[i]
 * i + j < n
 * ���ص��� nums[n - 1] ����С��Ծ���������ɵĲ����������Ե��� nums[n - 1]��
 *
 * ʾ�� 1:
 * ����: nums = [2,3,1,1,4]
 * ���: 2
 * ����: �������һ��λ�õ���С��Ծ���� 2��
 * ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
 *
 * ʾ�� 2:
 * ����: nums = [2,3,0,1,4]
 * ���: 2
 */
fun main() {
    println(jump1(intArrayOf(2, 3, 1, 1, 4)))
    println(jump1(intArrayOf(2, 3, 0, 1, 4)))
    println("---split line ---")
    println(jump2(intArrayOf(2, 3, 1, 1, 4)))
    println(jump2(intArrayOf(2, 3, 0, 1, 4)))
}

/**
 * ������ҳ���λ��
 *
 * ̰�ĵ�ѡ��������һ��λ����Զ���Ǹ�λ�ã�Ҳ���Ƕ�Ӧ�±���С���Ǹ�λ�á�
 * ��ˣ����ǿ��Դ����ұ������飬ѡ���һ������Ҫ���λ�á�
 * �ҵ����һ����Ծǰ���ڵ�λ��֮�����Ǽ���̰�ĵ�Ѱ�ҵ����ڶ�����Ծǰ���ڵ�λ�ã�
 * �Դ����ƣ�ֱ���ҵ�����Ŀ�ʼλ�á�
 */
private fun jump1(nums: IntArray): Int {
    var step = 0
    var position = nums.lastIndex

    while (position > 0) {
        for (i in 0 until position) {
            if (nums[i] + i >= position) {
                position = i
                ++step
                break
            }
        }
    }

    return step
}

private fun jump2(nums: IntArray): Int {
    var step = 0

    var maxPosition = 0
    var end = 0
    for (i in 0 until nums.lastIndex) {
        maxPosition = max(maxPosition, i + nums[i])

        if (i == end) {
            end = maxPosition
            ++step
        }
    }

    return step
}