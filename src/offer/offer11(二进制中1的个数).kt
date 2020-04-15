package offer

/**
 * Create by hzh on 2020/3/25.
 * ��������1�ĸ���
 *
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
fun main() {
    println(numberOf1(15))
}

/**
 * 1111 & 1110 = 1110
 * 1110 & 1101 = 1100
 * 1100 & 1011 = 1000
 * 1000 & 0111 = 0
 */
private fun numberOf1(n: Int): Int {
    var number = n
    var result = 0

    while (number != 0) {
        ++result
        number = number and number - 1
    }

    return result
}