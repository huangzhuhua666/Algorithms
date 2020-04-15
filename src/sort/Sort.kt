package sort

import print

/**
 * Create by hzh on 2020/4/15.
 */
private const val SIZE = 10

private val array1 = IntArray(SIZE)
private lateinit var array2: IntArray
private lateinit var array3: IntArray
private lateinit var array4: IntArray
private lateinit var array5: IntArray
private lateinit var array6: IntArray
private lateinit var array7: IntArray
private lateinit var array8: IntArray

fun main() {
    init()
    array1.print()

    // 查找无序数组中第k小的数
    println("数组中第6小的数为 -> ${findKthMin(array1, 0, SIZE - 1, 6)}")

    bubbleSort(array2) // 冒泡排序

    insertSort(array3) // 插入排序

    selectionSort(array4) // 选择排序

    mergeSort(array5, 0, SIZE - 1) // 归并排序

    quickSort(array6, 0, SIZE - 1) // 快速排序

    heapSort(array7) // 堆排序

    countingSort(array8, 100 * SIZE + 1) // 计数排序

    array2.print()
}

private fun init() {
    for (i in 0 until SIZE) {
        array1[i] = (Math.random() * 100 * SIZE + 1).toInt()
    }

    array2 = array1.copyOf()
    array3 = array1.copyOf()
    array4 = array1.copyOf()
    array5 = array1.copyOf()
    array6 = array1.copyOf()
    array7 = array1.copyOf()
    array8 = array1.copyOf()
}