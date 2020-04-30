package offer

import swap

/**
 * Create by hzh on 2020/4/30.
 * 最小的K个数
 *
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
fun main() {
    getLeastNumbers(intArrayOf(4, 5, 1, 6, 2, 7, 3, 8), 4)
}

/**
 * 求最小的k个数用最大堆可以解决
 */
private fun getLeastNumbers(array: IntArray, k: Int) {
    if (array.isEmpty() || k > array.size || k == 0) return

    if (k == array.size) {
        array.forEach(::println)
        return
    }

    val list = array.take(k).toIntArray()
    buildMaxHeap(list)

    for (i in k..array.lastIndex) {
        if (array[i] < list[0]) {
            list[0] = array[i]
            maxHeapify(list, 0)
        }
    }

    list.forEach(::println)
}

private fun buildMaxHeap(array: IntArray) {
    for (i in array.size / 2 - 1 downTo 0) {
        maxHeapify(array, i)
    }
}

private fun maxHeapify(array: IntArray, i: Int) {
    val left = 2 * i + 1
    val right = 2 * i + 2

    var max = i
    if (left < array.size && array[left] > array[max]) max = left

    if (right < array.size && array[right] > array[max]) max = left

    if (max != i) {
        array.swap(max, i)
        maxHeapify(array, max)
    }
}