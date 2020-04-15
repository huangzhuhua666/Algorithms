package sort

import swap

/**
 * Create by hzh on 2020/4/15.
 * 堆排序
 */
private var HEAP_SIZE: Int = 0

fun heapSort(array: IntArray) {
    buildMaxHeap(array) // 建一个最大堆

    for (i in array.size - 1 downTo 1) {
        array.swap(0, i) // 堆根结点元素与最后一个元素交换
        --HEAP_SIZE // 堆大小减一
        maxHeapify(array, 0) // 维持最大堆特性
    }
}

/**
 * 构建最大堆
 */
private fun buildMaxHeap(array: IntArray) {
    HEAP_SIZE = array.size

    // 调整最大堆，只需要对数组的一半长度操作即可
    for (i in array.size / 2 - 1 downTo 0) {
        maxHeapify(array, i)
    }
}

/**
 * 维持最大堆的特性
 */
private fun maxHeapify(array: IntArray, i: Int) {
    val left = 2 * i + 1
    val right = 2 * i + 2

    // 找到值最大的结点
    var max = i
    if (left < HEAP_SIZE && array[max] < array[left]) max = left

    if (right < HEAP_SIZE && array[max] < array[right]) max = right

    if (max != i) { //不符合最大堆条件，交换并继续往下调整
        array.swap(max, i)
        maxHeapify(array, max)
    }
}