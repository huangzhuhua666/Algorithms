package leetcode

/**
 * Create by hzh on 2020/4/11.
 * �ַ���ת������ (atoi)
 *
 * ������ʵ��һ��atoi������ʹ���ܽ��ַ���ת����������
 * ���ȣ��ú����������Ҫ�������õĿ�ͷ�ո��ַ���ֱ��Ѱ�ҵ���һ���ǿո���ַ�Ϊֹ����������ת���������£�
 * �����һ���ǿ��ַ�Ϊ�����߸���ʱ���򽫸÷�����֮���澡���ܶ�����������ַ�����������γ�һ���з���������
 * �����һ���ǿ��ַ������֣���ֱ�ӽ�����֮�������������ַ�����������γ�һ��������
 * ���ַ�������Ч����������֮��Ҳ���ܻ���ڶ�����ַ�����ô��Щ�ַ����Ա����ԣ����ǶԺ�����Ӧ�����Ӱ�졣
 *
 * ע�⣺
 * ������ַ����еĵ�һ���ǿո��ַ�����һ����Ч�����ַ����ַ���Ϊ�ջ��ַ����������հ��ַ�ʱ��
 * ����ĺ�������Ҫ����ת�������޷�������Чת����
 * ���κ�����£����������ܽ�����Ч��ת��ʱ���뷵��0��
 *
 * ��ʾ��
 * �����еĿհ��ַ�ֻ�����ո��ַ�' '��
 * �������ǵĻ���ֻ�ܴ洢 32 λ��С���з�����������ô����ֵ��ΧΪ[-2^31, 2^31 - 1]��
 * �����ֵ���������Χ���뷵��INT_MAX(2^31 - 1)��INT_MIN(-2^31)��
 */
fun main() {
    println(myAtoi("42"))
    println(myAtoi("   -42"))
    println(myAtoi("4193 with words"))
    println(myAtoi("words and 987"))
    println(myAtoi("-91283472332"))
    println(myAtoi("-2147483649"))
    println(myAtoi("2147483649"))
}

private fun myAtoi(str: String): Int = if (str.trim() == "") 0
else if (!isLegalNumStar(str.trim()[0])) 0
else when (str.trim()[0]) {
    '-' -> parseNum(str.trim().substring(1), true)
    '+' -> parseNum(str.trim().substring(1), false)
    else -> parseNum(str.trim().substring(0), false)
}

/**
 * �ж��Ƿ������ֻ�+��-��ͷ
 */
private fun isLegalNumStar(c: Char): Boolean = c in '0'..'9' || c == '+' || c == '-'

/**
 * �����ַ�ת��Ϊ����
 */
private fun parseNum(str: String, isNegative: Boolean): Int {
    var num = 0

    for (c in str) {
        if (c !in '0'..'9') break

        val add = c.toInt() - 48
        if (isOverflow(num, add, isNegative)) return if (isNegative) Int.MIN_VALUE else Int.MAX_VALUE

        num = 10 * num + add
    }

    return if (isNegative) -num else num
}

/**
 * �Ƿ����
 */
private fun isOverflow(num: Int, add: Int, isNegative: Boolean): Boolean = when (isNegative) {
    true -> -num < Int.MIN_VALUE / 10 || (-num == Int.MIN_VALUE / 10 && add > 8)
    false -> num > Int.MAX_VALUE / 10 || (num == Int.MAX_VALUE / 10 && add > 7)
}