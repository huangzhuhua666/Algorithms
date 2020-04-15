package sort

import swap

/**
 * Create by hzh on 2020/4/15.
 * 选择排序
 */
fun selectionSort(array: IntArray) {
    for (i in 0 until array.size - 1) {
        var minIndex = i // 假设当前位置的值是最小的

        for (j in i + 1 until array.size) {
            if (array[j] < array[minIndex]) minIndex = j
        }

        if (i != minIndex) array.swap(i, minIndex)
    }
}