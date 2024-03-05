package leetcode

import java.lang.StringBuilder

/**
 * Create by hzh on 2024/3/5.
 * �ַ������
 *
 * �����������ַ�����ʽ��ʾ�ķǸ����� num1 �� num2������ num1 �� num2 �ĳ˻������ǵĳ˻�Ҳ��ʾΪ�ַ�����ʽ��
 * ע�⣺����ʹ���κ����õ� BigInteger ���ֱ�ӽ�����ת��Ϊ������
 *
 * ʾ�� 1:
 * ����: num1 = "2", num2 = "3"
 * ���: "6"
 *
 * ʾ�� 2:
 * ����: num1 = "123", num2 = "456"
 * ���: "56088"
 */
fun main() {
    println(multiply("2", "3"))
    println(multiply("123", "456"))
    println(multiply("0", "456"))
    println(multiply("9", "9"))
    println(multiply("9", "99"))
}

private fun multiply(num1: String, num2: String): String {
    if (num1.trim().isEmpty() || num2.trim().isEmpty()) {
        return ""
    }
    if (num1.isZero() || num2.isZero()) {
        return "0"
    }

    val sums = IntArray(num1.length + num2.length)
    for (i in num1.indices) {
        val digit1 = num1[num1.lastIndex - i] - '0'

        for (j in num2.indices) {
            val digit2 = num2[num2.lastIndex - j] - '0'
            sums[i + j] += digit1 * digit2
        }
    }

    val sb = StringBuilder()
    for (i in sums.indices) {
        if (sums[i] >= 10) {
            sums[i + 1] += sums[i] / 10
            sums[i] = sums[i] % 10
        }

        if (i == sums.lastIndex && sums[i] == 0) {
            break
        }

        sb.append(sums[i])
    }

    return sb.reverse().toString()
}

private fun String.isZero(): Boolean {
    return length == 1 && this[0] - '0' == 0
}