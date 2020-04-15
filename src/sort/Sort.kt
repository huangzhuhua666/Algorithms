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

    // �������������е�kС����
    println("�����е�6С����Ϊ -> ${findKthMin(array1, 0, SIZE - 1, 6)}")

    bubbleSort(array2) // ð������

    insertSort(array3) // ��������

    selectionSort(array4) // ѡ������

    mergeSort(array5, 0, SIZE - 1) // �鲢����

    quickSort(array6, 0, SIZE - 1) // ��������

    heapSort(array7) // ������

    countingSort(array8, 100 * SIZE + 1) // ��������

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