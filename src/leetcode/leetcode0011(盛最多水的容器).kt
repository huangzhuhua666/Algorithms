package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * Create by hzh on 2020/4/13.
 * ʢ���ˮ������
 *
 * ����n���Ǹ�����a1��a2��...��an��ÿ�������������е�һ����(i, ai)��
 * �������ڻ�n����ֱ�ߣ���ֱ��i�������˵�ֱ�Ϊ(i, ai) �� (i, 0)��
 * �ҳ����е������ߣ�ʹ��������x�Ṳͬ���ɵ�����������������ˮ��
 * ˵�����㲻����б��������n��ֵ����Ϊ2��
 */
fun main() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}

/**
 * ˫�±꣬������
 */
private fun maxArea(height: IntArray): Int = when (height.size < 2) {
    true -> 0
    false -> when (height.size == 2) {
        true -> min(height[0], height[1])
        false -> {
            var result = Int.MIN_VALUE
            var left = 0
            var right = height.size - 1

            while (left < right) {
                result = max(result, min(height[left], height[right]) * (right - left))

                if (height[left] <= height[right]) ++left
                else --right
            }

            result
        }
    }
}