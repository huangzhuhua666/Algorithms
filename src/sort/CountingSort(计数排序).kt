package sort

/**
 * Create by hzh on 2020/4/15.
 * 计数排序
 */

/**
 * 98	174	625	878	219	953	492	498	855	930
 * 98 -> 1
 * 174 -> 1
 * 219 -> 1
 * 492 -> 1
 * 498 -> 1
 * 625 -> 1
 * 855 -> 1
 * 878 -> 1
 * 930 -> 1
 * 953 -> 1
 */
fun countingSort(array: IntArray, max: Int) { // max是数组中可能出现的最大值
    val bucket = IntArray(max)

    for (i in array.indices) {
        ++bucket[array[i]] // 统计每个元素出现的次数
    }

    var index = 0
    for (i in bucket.indices) {
        // 元素归位
        while (bucket[i] != 0) {
            array[index++] = i
            --bucket[i]
        }
    }
}