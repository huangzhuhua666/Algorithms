package nowcoder

import swap

/**
 * Create by hzh on 2020/3/25.
 * 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
fun main() {
    intArrayOf(1, 2, 3, 4, 5, 6, 7, 9, 10).apply { reOrderArray(this) }.forEach { print("$it ") }
    println()
}

private fun reOrderArray(array: IntArray) {
    var i = array.size - 1
    var oddP = array.size - 1

    while (i >= 0) {
        if (array[i] and 1 == 0) {
            if (i != oddP) {
                for (j in oddP downTo i + 1) {
                    array.swap(i, j)
                }
            }
            --oddP
        }

        --i
    }
}