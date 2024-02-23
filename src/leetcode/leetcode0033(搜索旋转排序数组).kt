package leetcode

/**
 * Create by hzh on 2024/2/23.
 * ������ת��������
 *
 * �������� nums ���������У������е�ֵ ������ͬ ��
 * �ڴ��ݸ�����֮ǰ��nums ��Ԥ��δ֪��ĳ���±� k��0 <= k < nums.length���Ͻ����� ��ת��
 * ʹ�����Ϊ [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]���±� �� 0 ��ʼ ��������
 * ���磬 [0,1,2,4,5,6,7] ���±� 3 ������ת����ܱ�Ϊ [4,5,6,7,0,1,2] ��
 * ���� ��ת�� ������ nums ��һ������ target ����� nums �д������Ŀ��ֵ target ���򷵻������±꣬���򷵻� -1 ��
 * ��������һ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��������⡣
 *
 * ʾ�� 1��
 * ���룺nums = [4,5,6,7,0,1,2], target = 0
 * �����4
 *
 * ʾ�� 2��
 * ���룺nums = [4,5,6,7,0,1,2], target = 3
 * �����-1
 *
 * ʾ�� 3��
 * ���룺nums = [1], target = 0
 * �����-1
 */
fun main() {
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    println(search(intArrayOf(1), 0))
    println(search(intArrayOf(1, 3), 0))
    println(search(intArrayOf(1, 3), 3))
    println(search(intArrayOf(5, 1, 3), 1))
}

private fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) {
        return -1
    }

    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        if (nums[mid] == target) {
            return mid
        }

        if (nums[left] <= nums[mid]) {
            // ǰ�벿���������
            if (target in nums[left] until nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            // ��벿���������
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }

    return -1
}