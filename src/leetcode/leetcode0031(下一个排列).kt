package leetcode

/**
 * Create by hzh on 2024/2/22.
 * ��һ������
 *
 * ���������һ�� ����  ���ǽ������г�Ա�����л�����˳�����С�
 * ���磬arr = [1,2,3] ��������Щ���������� arr �����У�[1,2,3]��[1,3,2]��[3,1,2]��[2,3,1] ��
 * ��������� ��һ������ ��ָ����������һ���ֵ����������С�
 * ����ʽ�أ����������������и������ֵ�˳���С����������һ�������У�
 * ��ô����� ��һ������ �������������������������������Ǹ����С�
 * �����������һ����������У���ô��������������Ϊ�ֵ�����С�����У�������Ԫ�ذ��������У���
 * ���磬arr = [1,2,3] ����һ�������� [1,3,2] ��
 * ���Ƶأ�arr = [2,3,1] ����һ�������� [3,1,2] ��
 * �� arr = [3,2,1] ����һ�������� [1,2,3] ����Ϊ [3,2,1] ������һ���ֵ����������С�
 * ����һ���������� nums ���ҳ� nums ����һ�����С�
 * ���� ԭ�� �޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
 *
 * ʾ�� 1��
 * ���룺nums = [1,2,3]
 * �����[1,3,2]
 *
 * ʾ�� 2��
 * ���룺nums = [3,2,1]
 * �����[1,2,3]
 *
 * ʾ�� 3��
 * ���룺nums = [1,1,5]
 * �����[1,5,1]
 */
fun main() {
    println(nextPermutation(intArrayOf(1, 2, 3)).toList())
    println(nextPermutation(intArrayOf(3, 2, 1)).toList())
    println(nextPermutation(intArrayOf(1, 1, 5)).toList())
    println(nextPermutation(intArrayOf(1, 3, 2)).toList())
    println(nextPermutation(intArrayOf(1, 5, 1)).toList())
    println(nextPermutation(intArrayOf(5, 1, 1)).toList())
    println(nextPermutation(intArrayOf(5, 4, 7, 5, 3, 2)).toList())
}

private fun nextPermutation(nums: IntArray): IntArray {
    nextPermutation1(nums)
    return nums
}

private fun nextPermutation1(nums: IntArray) {
    if (nums.isEmpty() || nums.size == 1) {
        return
    }
    if (nums.size == 2) {
        // ���鳤��Ϊ 2��ֱ�ӽ�������ֵ
        swap(nums, 0, 1)
        return
    }

    val end = nums.size - 1
    // �Ӻ�����ǰ�����
    for (i in end downTo 1) {
        // �����һ������ǰһ����С��ǰ��
        if (nums[i] <= nums[i - 1]) {
            // ����Ѿ���ѯ������ڶ���Ԫ���ˣ�˵�������������ȫ�������еģ�ֱ�ӷ�ת����
            if (i == 1) {
                reverseNums(nums, 0, end)
                break
            } else {
                continue
            }
        }

        // �ҵ���һ��Ԫ��ʹ������ǰһ��Ԫ��ʹС�����ģ�����[5, 4, 7, 5, 3, 2]��7������ǰһ��Ԫ����4
        for (j in end downTo i) {
            // �ٴδӺ�����ң�ֱ����ǰԪ�ص�λ�ã��ҳ���һ������ǰһ��Ԫ�ش��
            if (nums[j] <= nums[i - 1]) {
                continue
            }

            // ����������Ԫ�أ�����[5, 5, 7, 4, 3, 2]
            swap(nums, i - 1, j)
            break
        }

        // ������i ~ end ��һ���ֱ�Ȼ�ǽ���ģ�ֱ�ӷ�ת����
        reverseNums(nums, i, end)
        break
    }
}

private fun swap(nums: IntArray, index1: Int, index2: Int) {
    val temp = nums[index1]
    nums[index1] = nums[index2]
    nums[index2] = temp
}

private fun reverseNums(nums: IntArray, start: Int, end: Int) {
    val len = end - start + 1
    for (i in 0 until len / 2) {
        swap(nums, i + start, len - i - 1 + start)
    }
}