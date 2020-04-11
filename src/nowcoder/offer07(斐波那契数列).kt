package nowcoder

/**
 * Create by hzh on 2020/3/25.
 * 斐波那契数列
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
fun main() {
    println(fibonacci1(39))
    println(fibonacci2(39))
}

/**
 * 非递归版，用一个数组保存前面的结果
 */
private fun fibonacci1(n: Int): Int = if (n <= 1) n
else {
    val result = IntArray(n + 1) {
        if (it == 1) 1
        else 0
    }

    for (i in 2..n) {
        result[i] = result[i - 1] + result[i - 2]
    }

    result[n]
}

/**
 * 递归版
 */
private fun fibonacci2(n: Int): Int = if (n <= 1) n
else fibonacci2(n - 1) + fibonacci2(n - 2)