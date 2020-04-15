package sort

import swap

/**
 * Create by hzh on 2020/4/15.
 * Ã°ÅİÅÅĞò
 */
fun bubbleSort(array: IntArray) {
    for (i in 0 until array.size - 1) {
        for (j in 0 until array.size - 1 - i) {
            if (array[j] > array[j + 1]) array.swap(j, j + 1)
        }
    }
}