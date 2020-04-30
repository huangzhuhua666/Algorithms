package offer

/**
 * Create by hzh on 2020/4/30.
 * �����г��ִ�������һ�������
 *
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 * ��������������0��
 */
fun main() {
    println(moreThanHalfNum(intArrayOf(1, 2, 3, 2, 2, 2, 5, 4, 2)))
}

private fun moreThanHalfNum(array: IntArray): Int = when (array.size) {
    0 -> 0
    else -> {
        var tag = 1
        var num = array[0]

        for (i in 1..array.lastIndex) {
            if (tag == 0) {
                tag = 1
                num = array[i]
            } else tag += if (num == array[i]) 1 else -1
        }

        if (isMoreThanHalf(array, num)) num else 0
    }
}

/**
 * �ж�������������г��ֵĴ����Ƿ���Ĵ������鳤�ȵ�һ��
 */
private fun isMoreThanHalf(array: IntArray, num: Int): Boolean {
    var count = 0
    for (n in array) {
        if (num == n) ++count
    }

    return count > array.size / 2
}