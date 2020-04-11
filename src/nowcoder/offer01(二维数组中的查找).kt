package nowcoder

/**
 * Create by hzh on 2020/3/17.
 * 二维数组中的查找
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
fun main() {
    val array = arrayOf(intArrayOf(1, 5, 9, 13),
            intArrayOf(2, 6, 10, 14),
            intArrayOf(3, 7, 11, 15),
            intArrayOf(4, 8, 12, 16))

    println(find(7, array))
}

private fun find(target: Int, array: Array<IntArray>): Boolean {
    var i = 0
    var j = array[0].size - 1

    // 从数组右上角开始搜索
    while (i < array.size && j > 0) {
        if (array[i][j] == target) return true // 当前值等于target，返回true

        if (array[i][j] > target) --j // 当前值比target大，往数组左边缩小范围
        else ++i // 当前值比target小，往数组下面缩小范围
    }

    return false // 找不到target
}