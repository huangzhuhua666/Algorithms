package leetcode

/**
 * Create by hzh on 2020/4/11.
 * ������ת
 *
 * ����һ��32λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��
 */
fun main() {
    println(reverse(1534236469))
}

private fun reverse(x: Int): Int {
    var num = x

    var newNum = 0
    while (num != 0) {
        val pop = num % 10
        num /= 10

        if (newNum > Int.MAX_VALUE / 10 || (newNum == Int.MAX_VALUE / 10 && pop > 7)) return 0
        if (newNum < Int.MIN_VALUE / 10 || (newNum == Int.MIN_VALUE / 10 && pop < -8)) return 0

        newNum = 10 * newNum + pop
    }

    return newNum
}