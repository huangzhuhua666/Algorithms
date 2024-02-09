package leetcode

/**
 * Create by hzh on 2024/2/9.
 * �Ƴ�Ԫ��
 *
 * ����һ������ nums ��һ��ֵ val������Ҫ ԭ�� �Ƴ�������ֵ���� val ��Ԫ�أ��������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬������ʹ�� O(1) ����ռ䲢 ԭ�� �޸��������顣
 * Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 *
 * ʾ�� 1��
 * ���룺nums = [3,2,2,3], val = 3
 * �����2, nums = [2,2]
 * ���ͣ�����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2���㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ���磬�������ص��³���Ϊ 2 ���� nums = [2,2,3,3] �� nums = [2,2,0,0]��Ҳ�ᱻ������ȷ�𰸡�
 *
 * ʾ�� 2��
 * ���룺nums = [0,1,2,2,3,0,4,2], val = 2
 * �����5, nums = [0,1,3,0,4]
 * ���ͣ�����Ӧ�÷����µĳ��� 5, ���� nums �е�ǰ���Ԫ��Ϊ 0, 1, 3, 0, 4��
 * ע�������Ԫ�ؿ�Ϊ����˳���㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 */
fun main() {
    println(removeElement(intArrayOf(3, 2, 2, 3), 3))
    println(removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
    println(removeElement(intArrayOf(1), 1))
    println(removeElement(intArrayOf(1, 1), 1))
    println(removeElement(intArrayOf(1, 1, 1), 1))
}

private fun removeElement(nums: IntArray, `val`: Int): Int {
    if (nums.size == 1) {
        return if (nums[0] == `val`) {
            0
        } else {
            1
        }
    }

    var result = nums.size

    var left = 0
    var right = nums.size - 1
    var temp: Int
    while (left <= right) {
        if (nums[right] == `val`) {
            --right
            --result
            continue
        }

        if (nums[left] == `val`) {
            temp = nums[right]
            nums[right--] = nums[left]
            nums[left] = temp

            --result
        }
        ++left
    }

    return result
}