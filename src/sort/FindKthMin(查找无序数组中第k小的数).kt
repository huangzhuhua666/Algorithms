package sort

import swap

/**
 * Create by hzh on 2020/4/15.
 * �������������е�kС����
 */
fun findKthMin(array: IntArray, low: Int, high: Int, k: Int): Int {
    if (low == high) return array[low]

    // ���ѡ��һ������Ϊ��Ԫ
    val rand = low + (Math.random() * (high - low + 1)).toInt()
    array.swap(rand, high)

    val index = partition(array, low, high)

    val n = index - low + 1

    return when (n == k) {
        true -> array[index] //
        false -> when (n < k) {
            true -> findKthMin(array, index + 1, high, k - n) // ������
            false -> findKthMin(array, low, index - 1, k) // ��ǰ��
        }
    }
}

private fun partition(array: IntArray, low: Int, high: Int): Int {
    val flag = array[high]
    var index = low - 1

    for (i in low until high) {
        if (array[i] < flag) {
            ++index // ÿ�ҵ�һ����flag�������index + 1
            array.swap(index, i) // ����index�͵�ǰλ�õ�ֵ
        }
    }

    array.swap(++index, high) // ��flag�ŵ����������е�ʵ��λ��

    return index
}