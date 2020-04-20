/**
 * Create by hzh on 2020/1/13.
 * 字符串匹配
 *
 * 输入两个字符串，检测字符串A是否包含字符串B，如果包含，输出其第一次出现的位置
 */
private const val A = "abaabaabbabaaabaabbabaab"
private const val B = "abaabbabaab"

fun main() {
    println("result -> ${br1()}")
    println("result -> ${br2()}")
    println("result -> ${kmp()}")
}

/**
 * 暴力解法，写法一
 */
private fun br1(): Int {
    var i = 0
    var j = 0

    while (i < A.length && j < B.length) {
        if (A[i] == B[j]) {
            ++i
            ++j

            if (j == B.length) return i - j
        } else {
            i = i - j + 1
            j = 0
        }
    }
    return -1
}

/**
 * 暴力解法，写法二
 */
private fun br2(): Int {
    for (i in 0..A.length - B.length) {
        var j = 0

        while (j < B.length) {
            if (A[i + j] != B[j]) break

            ++j
        }
        if (j == B.length) return i
    }

    return -1
}

/**
 * KMP算法
 */
private fun kmp(): Int {
    // 辅助数组，next[i]表示数组B前i + 1位字符串的最长相同的前缀和后缀的长度
    // 在匹配字符串时
    val next = IntArray(B.length) { -1 }

    // 求解数组B前i + 1位字符串的最长相同的前缀和后缀的长度
    // 可根据前一个子问题求得
    for (i in 1 until B.length) {
        var j = next[i - 1]

        while (B[j + 1] != B[i] && j >= 0) j = next[j]

        next[i] = if (B[j + 1] == B[i]) j + 1 else -1
    }

    var i = 0
    var j = 0
    while (i < A.length) {
        if (A[i] == B[j]) {
            ++i
            ++j

            if (j == B.length) return i - j
        } else {
            if (j == 0) ++i // B字符串第一个字符就和A字符串当前字符不匹配时，A字符串直接往后移一位
            // abaab aabbabaaabaabbabaab i = 5
            // abaab babaab              j = 5
            // 如上，第5位开始才不匹配，则
            // abaab aabbabaaabaabbabaab i = 5
            //    ab aabbabaab           j = 2
            // B字符串跳过next[5 - 1] + 1 = 2位，A字符串下标不变即可
            else j = next[j - 1] + 1
        }
    }

    return -1
}