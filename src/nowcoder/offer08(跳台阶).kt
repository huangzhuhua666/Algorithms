package nowcoder

/**
 * Create by hzh on 2020/3/25.
 * ��̨��
 *
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
 * �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 */
fun main() {
    println(jumpFloor1(5))
    println(jumpFloor2(5))
}

/**
 * 쳲������ⷨ
 */

private fun jumpFloor1(target: Int): Int = if (target <= 3) target
else {
    val result = IntArray(target + 1) {
        if (it <= 3) it
        else 0
    }

    for (i in 4..target) {
        result[i] = result[i - 1] + result[i - 2]
    }

    result[target]
}

private fun jumpFloor2(target: Int): Int = if (target <= 3) target
else jumpFloor2(target - 1) + jumpFloor2(target - 2)