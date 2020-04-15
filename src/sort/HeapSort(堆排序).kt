package sort

import swap

/**
 * Create by hzh on 2020/4/15.
 * ������
 */
private var HEAP_SIZE: Int = 0

fun heapSort(array: IntArray) {
    buildMaxHeap(array) // ��һ������

    for (i in array.size - 1 downTo 1) {
        array.swap(0, i) // �Ѹ����Ԫ�������һ��Ԫ�ؽ���
        --HEAP_SIZE // �Ѵ�С��һ
        maxHeapify(array, 0) // ά����������
    }
}

/**
 * ��������
 */
private fun buildMaxHeap(array: IntArray) {
    HEAP_SIZE = array.size

    // �������ѣ�ֻ��Ҫ�������һ�볤�Ȳ�������
    for (i in array.size / 2 - 1 downTo 0) {
        maxHeapify(array, i)
    }
}

/**
 * ά�����ѵ�����
 */
private fun maxHeapify(array: IntArray, i: Int) {
    val left = 2 * i + 1
    val right = 2 * i + 2

    // �ҵ�ֵ���Ľ��
    var max = i
    if (left < HEAP_SIZE && array[max] < array[left]) max = left

    if (right < HEAP_SIZE && array[max] < array[right]) max = right

    if (max != i) { //�����������������������������µ���
        array.swap(max, i)
        maxHeapify(array, max)
    }
}