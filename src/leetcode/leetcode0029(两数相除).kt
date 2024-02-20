package leetcode

import kotlin.math.abs

/**
 * Create by hzh on 2024/2/20.
 * �������
 *
 * �������������������� dividend �ͳ��� divisor�������������Ҫ�� ��ʹ�� �˷���������ȡ�����㡣
 * ��������Ӧ������ضϣ�Ҳ���ǽ�ȥ��truncate����С�����֡����磬8.345 �����ض�Ϊ 8 ��-2.7335 �����ض��� -2 ��
 * ���ر����� dividend ���Գ��� divisor �õ��� �� ��
 *
 * ע�⣺�������ǵĻ���ֻ�ܴ洢 32 λ �з�������������ֵ��Χ�� [?2^31,  2^31 ? 1] ��
 * �����У������ �ϸ���� 2^31 ? 1 ���򷵻� 2^31 ? 1 ������� �ϸ�С�� -2^31 ���򷵻� -2^31 ��
 *
 * ʾ�� 1:
 * ����: dividend = 10, divisor = 3
 * ���: 3
 * ����: 10/3 = 3.33333.. ������ضϺ�õ� 3 ��
 *
 * ʾ�� 2:
 * ����: dividend = 7, divisor = -3
 * ���: -2
 * ����: 7/-3 = -2.33333.. ������ضϺ�õ� -2 ��
 */
fun main() {
    println(divide(10, 3))
    println(divide(7, -3))
    println(divide(-2147483648, 1))
}

/**
 * �̡�����+����=������
 * ���ǿ��԰�һ��dividend�����������ȳ���2^n��n���Ϊ31�����ϼ�Сnȥ��̽,��ĳ��n����dividend/2^n>=divisorʱ��
 *
 * ��ʾ�����ҵ���һ���㹻������������*divisor�ǲ�����dividend�ģ��������ǾͿ��Լ�ȥ2^n��divisor���Դ�����
 *
 * ���ǿ�����100/3Ϊ��
 *
 * 2^n��1��2��4��8...2^31����������nΪ31ʱ��������ر��100/2^n��һ����С�������϶���С��3�ģ�����ѭ��������
 *
 * ��n=5ʱ��100/32=3, �պ��Ǵ��ڵ���3�ģ���ʱ���ǽ�100-32*3=4��Ҳ���Ǽ�ȥ��32��3�������������ٴ���4��ͬ���ַ������ټ�ȥһ��3
 *
 * ����һ���Ǽ�ȥ��33��3�������̾���33
 */
private fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == 0) {
        return 0
    }

    if (dividend == Int.MIN_VALUE && divisor == -1) {
        return Int.MAX_VALUE
    }

    // �����Ƿ��෴
    val isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)
    var newDividend = abs(dividend.toLong())
    val newDivisor = abs(divisor.toLong())

    var result = 0
    for (i in 31 downTo 0) {
        // �ҳ��㹻����� 2^n * divisor
        if ((newDividend shr i) >= newDivisor) {
            // ���������2^n
            result += 1 shl i
            // ����������ȥ 2^n * divisor
            newDividend -= newDivisor shl i
        }
    }

    return if (isNegative) {
        -result
    } else {
        result
    }
}