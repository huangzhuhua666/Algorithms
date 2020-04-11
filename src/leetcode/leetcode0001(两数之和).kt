package leetcode

/**
 * Create by hzh on 2020/4/10.
 * ����֮��
 *
 * ����һ����������nums��һ��Ŀ��ֵtarget�������ڸ��������ҳ���ΪĿ��ֵ�����������������������ǵ������±ꡣ
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
 */
fun main() {
    twoSum(intArrayOf(-3, 4, 3, 90), 0).forEach(::println)
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, i ->
        if (map.containsKey(target - i)) {
            result[0] = map[target - i]!!
            result[1] = index
        } else map[i] = index
    }

    return result
}