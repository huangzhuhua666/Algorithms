package offer

/**
 * Create by hzh on 2020/5/22.
 * �����е������
 *
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P��
 * ����P��1000000007ȡģ�Ľ������������P%1000000007
 *
 * ����
 * ���룺1,2,3,4,5,6,7,0
 * �����7
 */
fun main() {
    println(inversePairs(intArrayOf(1, 2, 3, 4, 5, 6, 7, 0)))
}

private var count: Int = 0

/**
 * �鲢�����ͬʱ����
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
 * ����ָ��ָ��������Ҫ�ϲ��������ĩβ��
 * ���ǰһ��ָ��ָ���Ԫ�رȺ�һ���󣬼����һ��ָ���������ͷ����Ԫ��������Ȼ��ǰһ��ָ����ǰ�ƶ���
 * �����Ҫ�ϲ����飬ʹ�����򣬱����ظ����㡣
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
