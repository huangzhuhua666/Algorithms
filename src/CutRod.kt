/**
 * Create by hzh on 2020/1/14.
 */
/**
 * ���ӳ��ȶ�Ӧ�ļ۸�
 */
private val PRICE = intArrayOf(1, 5, 8, 9, 10, 17, 17, 20, 24, 30)

fun main() {
    println("result -> ${cutRod(7)}")
}

/**
 * ����һ�δ�С�����ӣ�����ô�п����������
 * @param length ���ӳ���
 * @return �������
 */
private fun cutRod(length: Int): Int {
    val result = IntArray(length + 1) { 0 }

    for (i in 1..length) {
        var max = -Int.MAX_VALUE
        for (j in 1..i) {
            // �ֽ�����ɸ�������
            (PRICE[j - 1] + result[i - j]).let { if (max < it) max = it }
        }
        result[i] = max
    }

    return result[length]
}