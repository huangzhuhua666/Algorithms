package leetcode

/**
 * Create by hzh on 2024/3/7.
 * ȫ����
 *
 * ����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ������� ������˳�� ���ش𰸡�
 *
 * ʾ�� 1��
 * ���룺nums = [1,2,3]
 * �����[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * ʾ�� 2��
 * ���룺nums = [0,1]
 * �����[[0,1],[1,0]]
 *
 * ʾ�� 3��
 * ���룺nums = [1]
 * �����[[1]]
 */
fun main() {
    println(permute(intArrayOf(1, 2, 3)))
    println(permute(intArrayOf(0, 1)))
    println(permute(intArrayOf(1)))
}

private fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtrack(nums, 0, result)
    return result
}

private fun backtrack(nums: IntArray, index: Int, result: MutableList<List<Int>>) {
    if (index == nums.lastIndex) {
        result.add(nums.toList())
        return
    }

    for (i in index..nums.lastIndex) {
        swap(nums, i, index)
        backtrack(nums, index + 1, result)
        swap(nums, i, index)
    }
}

private fun swap(nums: IntArray, index1: Int, index2: Int) {
    if (index1 == index2) {
        return
    }

    val temp = nums[index1]
    nums[index1] = nums[index2]
    nums[index2] = temp
}