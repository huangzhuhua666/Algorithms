package leetcode

/**
 * Create by hzh on 2024/1/24.
 * ����֮��
 *
 * ����һ���������� nums ���ж��Ƿ������Ԫ��
 * [nums[i], nums[j], nums[k]] ���� i != j��i != k �� j != k ��
 * ͬʱ������ nums[i] + nums[j] + nums[k] == 0 ��
 * ���㷵�����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 *
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 *
 * ʾ�� 1��
 * ���룺nums = [-1,0,1,2,-1,-4]
 * �����[[-1,-1,2],[-1,0,1]]
 * ���ͣ�
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 ��
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 ��
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 ��
 * ��ͬ����Ԫ���� [-1,0,1] �� [-1,-1,2] ��
 * ע�⣬�����˳�����Ԫ���˳�򲢲���Ҫ��
 *
 * ʾ�� 2��
 * ���룺nums = [0,1,1]
 * �����[]
 * ���ͣ�Ψһ���ܵ���Ԫ��Ͳ�Ϊ 0 ��
 *
 * ʾ�� 3��
 * ���룺nums = [0,0,0]
 * �����[[0,0,0]]
 * ���ͣ�Ψһ���ܵ���Ԫ���Ϊ 0 ��
 */
fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum(intArrayOf(0, 0, 0)))
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4)))

    println(threeSum1(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum1(intArrayOf(0, 0, 0)))
    println(threeSum1(intArrayOf(-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4)))
}

/**
 * �̶�һ��������ʣ��Ĳ�ֵ������֮�͵ķ�������ʱ�䳬����Ҫ�����ȥ�أ��ƣ�
 */
private fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableSetOf<List<Int>>()

    nums.forEachIndexed { index, i ->
        result.addAll(twoSum(nums, index, 0 - i))
    }

    return result.toList()
}

private fun twoSum(nums: IntArray, currIndex: Int, target: Int): Set<List<Int>> {
    val result = mutableSetOf<List<Int>>()
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        if (i == currIndex) {
            continue
        }

        if (map.containsKey(target - nums[i])) {
            result.add(listOf(0 - target, nums[i], target - nums[i]).sorted())
        } else {
            map[nums[i]] = i
        }
    }

    return result
}

/**
 * ���� + ˫ָ��
 */
private fun threeSum1(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    nums.sort()

    for (first in 0 until nums.size - 2) {
        if (nums[first] > 0) {
            // ��һ��Ԫ�ش���0����ô���������飬�������Ԫ�ض�����0�����ԺͲ�����Ϊ0�ˣ�ֱ������
            break
        }

        if (first > 0 && nums[first] == nums[first - 1]) {
            // ������Ԫ�أ���Ϊ��ǰһ��Ԫ����ͬ��ǰһ��Ԫ���Ѿ���������϶��������ˣ�������ֻ��õ��ظ���Ԫ�أ�����
            continue
        }

        var second = first + 1
        var third = nums.size - 1
        while (second < third) {
            val sum = nums[first] + nums[second] + nums[third]

            when {
                sum < 0 -> {
                    // ��С��0��������������������ͬ��Ԫ��
                    while (second < third && nums[second] == nums[++second]);
                }
                sum > 0 -> {
                    // �ʹ���0��������������������ͬ��Ԫ��
                    while (second < third && nums[third] == nums[--third]);
                }
                else -> {
                    // ��Ϊ0����¼�������������ָ�����м�������������ͬ��Ԫ��
                    result.add(listOf(nums[first], nums[second], nums[third]))
                    while (second < third && nums[second] == nums[++second]);
                    while (second < third && nums[third] == nums[--third]);
                }
            }
        }
    }

    return result
}