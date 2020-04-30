package offer

/**
 * Create by hzh on 2020/4/30.
 * 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
fun main() {
    println(moreThanHalfNum(intArrayOf(1, 2, 3, 2, 2, 2, 5, 4, 2)))
}

private fun moreThanHalfNum(array: IntArray): Int = when (array.size) {
    0 -> 0
    else -> {
        var tag = 1
        var num = array[0]

        for (i in 1..array.lastIndex) {
            if (tag == 0) {
                tag = 1
                num = array[i]
            } else tag += if (num == array[i]) 1 else -1
        }

        if (isMoreThanHalf(array, num)) num else 0
    }
}

/**
 * 判断这个数在数组中出现的次数是否真的大于数组长度的一半
 */
private fun isMoreThanHalf(array: IntArray, num: Int): Boolean {
    var count = 0
    for (n in array) {
        if (num == n) ++count
    }

    return count > array.size / 2
}