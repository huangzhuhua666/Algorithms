package sort

import swap

/**
 * Create by hzh on 2020/4/15.
 * 快速排序
 */
fun quickSort(array: IntArray, low: Int, high: Int) {
    var l = low

    while (l < high) {
        // 随机选择一个数与数组high位交换，作为比较值
        val rand = l + (Math.random() * (high - l + 1)).toInt()
        array.swap(rand, high)

        // 得到比较值实际位置，在它前面的数比它小，在它后面的数比它大
        val index = partition(array, l, high)

        quickSort(array, l, index - 1) // 往前继续排序
        l = index + 1 // 往后继续排序
    }
}

private fun partition(array: IntArray, low: Int, high: Int): Int {
    val flag = array[high]
    var index = low - 1

    for (i in low until high) {
        if (array[i] < flag) {
            ++index // 每找到一个比flag大的数，index + 1
            array.swap(i, index) // 交换index和当前位置的值
        }
    }

    array.swap(++index, high) // 把flag放到它在数组中的实际位置

    return index
}