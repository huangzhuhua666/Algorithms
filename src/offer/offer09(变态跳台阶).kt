package offer

/**
 * Create by hzh on 2020/3/25.
 * ��̬��̨��
 *
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
 * �����������һ��n����̨���ܹ��ж�����������
 */
fun main() {
    println(jumpFloorII(5))
}

/**
 * 2 ^ (target - 1)
 */
private fun jumpFloorII(target: Int): Int = if (target == 0) 0
else 1 shl target - 1