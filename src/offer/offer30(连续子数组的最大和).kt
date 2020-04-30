package offer

import kotlin.math.max

/**
 * Create by hzh on 2020/4/30.
 * ���������������
 *
 * �ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
 * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * ��һ�����飬��������������������еĺ͡�
 */
fun main() {
    println(findGreatestSumOfSubArray(intArrayOf(6, -3, -2, 7, -15, 1, 2, 2)))
}

/**
 * ��̬�滮
 */
private fun findGreatestSumOfSubArray(array: IntArray): Int = if (array.isEmpty()) 0
else {
    var result = array[0] // ��¼��ǰ����������ĺ͵����ֵ
    var subArrayMax = array[0] // ����array[i]�������������ֵ

    for (i in 1..array.lastIndex) {
        subArrayMax = max(subArrayMax + array[i], array[i])
        result = max(result, subArrayMax)
    }

    result
}