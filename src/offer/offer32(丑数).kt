package offer

import kotlin.math.min

/**
 * Create by hzh on 2020/5/18.
 * ����
 *
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ������������7��
 * ϰ�������ǰ�1�����ǵ�һ��������
 * �󰴴�С�����˳��ĵ�N��������
 */
fun main() {
    println(getUglyNumber(18))
    println(getUglyNumber(20))
}

/**
 * 1 2 3 4 5 6 8 9 10 12 15 16 18 20 24 25 27 30 32 36
 *
 * һ����������ǰ��ĳһ��������2����3���5�õ���
 */
private fun getUglyNumber(index: Int): Int = if (index < 1) 0
else {
    val array = IntArray(index) { if (it == 0) 1 else 0 }

    var mul2 = 0
    var mul3 = 0
    var mul5 = 0

    for (next in 1 until index) {
        array[next] = min(array[mul2] * 2, min(array[mul3] * 3, array[mul5] * 5))

        if (array[mul2] * 2 == array[next]) ++mul2

        if (array[mul3] * 3 == array[next]) ++mul3

        if (array[mul5] * 5 == array[next]) ++mul5
    }

    array.last()
}