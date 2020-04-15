package sort

/**
 * Create by hzh on 2020/4/15.
 * 归并排序
 */
fun mergeSort(array: IntArray, low: Int, high: Int) {
    if (low < high) {
        // 将一个问题分解为两个子问题
        val mid = (low + high) / 2
        mergeSort(array, low, mid)
        mergeSort(array, mid + 1, high)
        // 将两个子问题的解合并
        merge(array, low, mid, high)
    }
}

private fun merge(array: IntArray, low: Int, mid: Int, high: Int) {
    val leftLen = mid - low + 1
    val rightLen = high - mid

    val left = IntArray(leftLen)
    val right = IntArray(rightLen)

    for (i in 0 until leftLen) {
        left[i] = array[i + low]
    }

    for (i in 0 until rightLen) {
        right[i] = array[i + mid + 1]
    }

    var i = 0
    var j = 0
    var index = low

    while (i < leftLen && j < rightLen) {
        array[index++] = if (left[i] <= right[j]) left[i++]
        else right[j++]
    }

    while (i < leftLen) { // 数组后半部分已经归并完毕，前半部分还有元素
        array[index++] = left[i++]
    }

    while (j < rightLen) { // 数组前半部分已经归并完毕，后半部分还有元素
        array[index++] = right[j++]
    }
}