package sort

import swap

/**
 * Create by hzh on 2020/4/15.
 * ²åÈëÅÅĞò
 */
fun insertSort(array: IntArray) {
    for (i in array.indices) {
        var index = i - 1
        val tmp = array[i]

        while (index >= 0 && array[index] > tmp) {
            array.swap(index, index + 1)
            --index
        }

        array[index + 1] = tmp
    }
}