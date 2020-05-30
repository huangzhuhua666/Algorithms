package offer

/**
 * Create by hzh on 2020/5/22.
 * 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。即输出P%1000000007
 *
 * 例：
 * 输入：1,2,3,4,5,6,7,0
 * 输出：7
 */
fun main() {
    println(inversePairs(intArrayOf(1, 2, 3, 4, 5, 6, 7, 0)))
}

private var count: Int = 0

/**
 * 归并排序的同时计数
 */
private fun inversePairs(array: IntArray): Int = if (array.size < 2) 0
else {
    count = 0

    splitArray(array, 0, array.lastIndex)

    count
}

private fun splitArray(array: IntArray, start: Int, end: Int) {
    if (start < end) {
        val mid = (start + end) / 2
        splitArray(array, start, mid)
        splitArray(array, mid + 1, end)
        mergeArray(array, start, mid, end)
    }
}

/**
 * 两个指针指向两个需要合并的数组的末尾。
 * 如果前一个指针指向的元素比后一个大，计算后一个指针距离数组头部的元素数量，然后前一个指针往前移动。
 * 最后需要合并数组，使其有序，避免重复计算。
 */
private fun mergeArray(array: IntArray, start: Int, mid: Int, end: Int) {
    val temp = IntArray(end - start + 1)
    var i = mid
    var j = end
    var k = temp.lastIndex

    while (i >= start && j > mid) {
        temp[k--] = if (array[i] > array[j]) {
            count += j - mid
            count %= 1000000007
            array[i--]
        } else array[j--]
    }

    while (j > mid) {
        temp[k--] = array[j--];
    }

    while (i >= start) {
        temp[k--] = array[i--];
    }

    temp.forEachIndexed { index, num -> array[start + index] = num }
}
