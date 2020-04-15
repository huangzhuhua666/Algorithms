package sort

import swap

/**
 * Create by hzh on 2020/4/15.
 * 查找无序数组中第k小的数
 */
fun findKthMin(array: IntArray, low: Int, high: Int, k: Int): Int {
    if (low == high) return array[low]

    // 随机选择一个数作为主元
    val rand = low + (Math.random() * (high - low + 1)).toInt()
    array.swap(rand, high)

    val index = partition(array, low, high)

    val n = index - low + 1

    return when (n == k) {
        true -> array[index] //
        false -> when (n < k) {
            true -> findKthMin(array, index + 1, high, k - n) // 往后找
            false -> findKthMin(array, low, index - 1, k) // 往前找
        }
    }
}

private fun partition(array: IntArray, low: Int, high: Int): Int {
    val flag = array[high]
    var index = low - 1

    for (i in low until high) {
        if (array[i] < flag) {
            ++index // 每找到一个比flag大的数，index + 1
            array.swap(index, i) // 交换index和当前位置的值
        }
    }

    array.swap(++index, high) // 把flag放到它在数组中的实际位置

    return index
}