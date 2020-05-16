package offer

import kotlin.math.max
import kotlin.math.min

/**
 * Create by hzh on 2020/5/16.
 * ������1���ֵĴ���
 *
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
 * ������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�������1�� n��1���ֵĴ�������
 */
fun main() {
    println(numberOf1Between1AndN(13))
}

/**
 * ��λ��1ÿ��10����1�Σ�
 * k = n % 10
 * n / 10  + if (k > 1) 1 else if(k < 1) 0 else k - 1 + 1
 *
 * ʮλ��1ÿ��100����10�Σ�
 * k = n % 100
 * n / 100 * 10 + if (k > 19) 10 else if (k < 10) 0 else k - 10 + 1
 *
 * ��λ��1ÿ��1000����100�Σ�
 * k = n % 100
 * n / 1000 * 100 + if(k > 199) 100 else if(k < 100) 0 else k - 100 + 1
 * ��������
 *
 * �ɹ��ɳ���
 * i = 1��10��100��1000����
 * k = n % (i * 10)
 * count(i) = n / (i * 10) * i + if (k > 2 * i - 1) i else if (k < i) 0 else k - i + 1
 * sum = sum(count(i))
 *
 * ��k - i + 1��ֻ��Ҫ��֤����[0, i]�����ڼ��ɣ�������
 * count(i) = n / (i * 10) * i + min(i, max(0, k - i + 1))
 */
private fun numberOf1Between1AndN(n: Int): Int = if (n <= 0) 0
else {
    var count = 0

    var i = 1
    while (i <= n) {
        val divider = i * 10
        val k = n % divider

        count += n / divider * i + min(i, max(0, k - i + 1))

        i *= 10
    }

    count
}