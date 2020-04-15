package sort

/**
 * Create by hzh on 2020/4/15.
 * �鲢����
 */
fun mergeSort(array: IntArray, low: Int, high: Int) {
    if (low < high) {
        // ��һ������ֽ�Ϊ����������
        val mid = (low + high) / 2
        mergeSort(array, low, mid)
        mergeSort(array, mid + 1, high)
        // ������������Ľ�ϲ�
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

    while (i < leftLen) { // �����벿���Ѿ��鲢��ϣ�ǰ�벿�ֻ���Ԫ��
        array[index++] = left[i++]
    }

    while (j < rightLen) { // ����ǰ�벿���Ѿ��鲢��ϣ���벿�ֻ���Ԫ��
        array[index++] = right[j++]
    }
}