package leetcode

/**
 * Create by hzh on 2024/2/9.
 * ɾ�����������е��ظ���
 *
 * ����һ�� ���ϸ�������� ������ nums ������ ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹÿ��Ԫ�� ֻ����һ�� ��
 * ����ɾ����������³��ȡ�Ԫ�ص� ���˳�� Ӧ�ñ��� һ�� ��
 * Ȼ�󷵻� nums ��ΨһԪ�صĸ�����
 * ���� nums ��ΨһԪ�ص�����Ϊ k ������Ҫ����������ȷ����������Ա�ͨ����
 * �������� nums ��ʹ nums ��ǰ k ��Ԫ�ذ���ΨһԪ�أ���������������� nums �г��ֵ�˳�����С�
 * nums ������Ԫ���� nums �Ĵ�С����Ҫ��
 * ���� k ��
 *
 * ʾ�� 1��
 * ���룺nums = [1,1,2]
 * �����2, nums = [1,2,_]
 * ���ͣ�����Ӧ�÷����µĳ��� 2 ������ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2 ��
 * ����Ҫ���������г����³��Ⱥ����Ԫ�ء�
 *
 * ʾ�� 2��
 * ���룺nums = [0,0,1,1,1,2,2,3,3,4]
 * �����5, nums = [0,1,2,3,4]
 * ���ͣ�����Ӧ�÷����µĳ��� 5 �� ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4 ��
 * ����Ҫ���������г����³��Ⱥ����Ԫ�ء�
 */
fun main() {
    println(removeDuplicates(intArrayOf(1, 1, 2)))
    println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
    println(removeDuplicates(intArrayOf(1, 2, 3)))
}

private fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty() || nums.size == 1) {
        return nums.size
    }
    if (nums.size == 2) {
        return if (nums[0] != nums[1]) {
            2
        } else {
            1
        }
    }

    var result = 1
    var i = 0
    var j = i + 1
    var temp: Int
    while (i < nums.size && j < nums.size) {
        if (nums[i] != nums[j]) {
            temp = nums[j]
            nums[j] = nums[++i]
            nums[i] = temp

            ++result
        }

        ++j
    }

    return result
}