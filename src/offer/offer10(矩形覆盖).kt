package offer

/**
 * Create by hzh on 2020/3/25.
 * 矩形覆盖
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
fun main() {
    println(rectCover1(4))
    println(rectCover2(4))
}

private fun rectCover1(target: Int): Int = if (target <= 3) target
else {
    val result = IntArray(target + 1) {
        if (it <= 3) it
        else 0
    }

    for (i in 4..target) {
        result[i] = result[i - 1] + result[i - 2]
    }

    result[target]
}

private fun rectCover2(target: Int): Int = if (target <= 3) target
else rectCover2(target - 1) + rectCover2(target - 2)