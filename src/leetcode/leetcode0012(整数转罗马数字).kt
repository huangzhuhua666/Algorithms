package leetcode

/**
 * Create by hzh on 2020/4/13.
 * 整数转罗马数字
 */
fun main() {
    println(intToRoman(3))
    println(intToRoman(4))
    println(intToRoman(9))
    println(intToRoman(58))
    println(intToRoman(1994))
}

private fun intToRoman(num: Int): String {
    val ge = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    val shi = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val bai = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val qian = arrayOf("", "M", "MM", "MMM")
    return qian[num / 1000] + bai[num % 1000 / 100] + shi[num % 100 / 10] + ge[num % 10]
}