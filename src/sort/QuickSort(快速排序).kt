package sort

import swap

/**
 * Create by hzh on 2020/4/15.
 * ��������
 */
fun quickSort(array: IntArray, low: Int, high: Int) {
    var l = low

    while (l < high) {
        // ���ѡ��һ����������highλ��������Ϊ�Ƚ�ֵ
        val rand = l + (Math.random() * (high - l + 1)).toInt()
        array.swap(rand, high)

        // �õ��Ƚ�ֵʵ��λ�ã�����ǰ���������С�������������������
        val index = partition(array, l, high)

        quickSort(array, l, index - 1) // ��ǰ��������
        l = index + 1 // �����������
    }
}

private fun partition(array: IntArray, low: Int, high: Int): Int {
    val flag = array[high]
    var index = low - 1

    for (i in low until high) {
        if (array[i] < flag) {
            ++index // ÿ�ҵ�һ����flag�������index + 1
            array.swap(i, index) // ����index�͵�ǰλ�õ�ֵ
        }
    }

    array.swap(++index, high) // ��flag�ŵ����������е�ʵ��λ��

    return index
}