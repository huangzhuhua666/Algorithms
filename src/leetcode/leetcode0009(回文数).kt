package leetcode

/**
 * Create by hzh on 2020/4/11.
 * ������
 *
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 */
fun main() {
    println(isPalindrome(121))
    println(isPalindrome(-121))
    println(isPalindrome(10))
    println(isPalindrome(9))
    println(isPalindrome(2332))
    println(isPalindrome(2333))
}

private fun isPalindrome(x: Int): Boolean = when {
    x < 0 || (x % 10 == 0 && x != 0) -> false // �������ǻ���������0��β����Ҳ�������ǻ�����
    x < 10 -> true // 0..10�������ǻ�����
    else -> { // �������
        var num = x
        var newNum = 0

        while (num > newNum) { // ��ת���ֺ�벿��
            newNum = 10 * newNum + num % 10
            num /= 10
        }

        // ������ֺ�벿�ַ�ת���ǰ�벿�ִ�С��ͬ
        // ��������������λ������x = 121..���Ƶ�����ʱ��newNum / 10 == x��������ʱ��Ϊ������
        num == newNum || newNum / 10 == num
    }
}