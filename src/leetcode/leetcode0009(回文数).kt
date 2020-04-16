package leetcode

/**
 * Create by hzh on 2020/4/11.
 * 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
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
    x < 0 || (x % 10 == 0 && x != 0) -> false // 负数不是回文数，以0结尾的数也不可能是回文数
    x < 10 -> true // 0..10的数都是回文数
    else -> { // 其他情况
        var num = x
        var newNum = 0

        while (num > newNum) { // 反转数字后半部分
            newNum = 10 * newNum + num % 10
            num /= 10
        }

        // 如果数字后半部分反转后和前半部分大小相同
        // 或者数字是奇数位，即当x = 121..类似的数字时，newNum / 10 == x条件成立时，为回文数
        num == newNum || newNum / 10 == num
    }
}