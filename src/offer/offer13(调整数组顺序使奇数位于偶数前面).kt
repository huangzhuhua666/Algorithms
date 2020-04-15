package offer

import swap

/**
 * Create by hzh on 2020/3/25.
 * ��������˳��ʹ����λ��ż��ǰ��
 *
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 */
fun main() {
    intArrayOf(1, 2, 3, 4, 5, 6, 7, 9, 10).apply { reOrderArray(this) }.forEach { print("$it ") }
    println()
}

private fun reOrderArray(array: IntArray) {
    var i = array.size - 1
    var oddP = array.size - 1

    while (i >= 0) {
        if (array[i] and 1 == 0) {
            if (i != oddP) {
                for (j in oddP downTo i + 1) {
                    array.swap(i, j)
                }
            }
            --oddP
        }

        --i
    }
}