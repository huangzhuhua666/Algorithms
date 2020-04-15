package offer

/**
 * Create by hzh on 2020/3/20.
 * 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
fun main() {
    println(minNumberInRotateArray(intArrayOf(5, 1, 2, 3, 4)))
    println(minNumberInRotateArray(intArrayOf(1, 0, 1, 1, 1)))
}

private fun minNumberInRotateArray(array: IntArray): Int {
    if (array.isEmpty()) return 0

    var left = 0
    var right = array.size - 1
    var mid = 0

    while (array[left] >= array[right]) {
        if (right - left == 1) {
            mid = right
            break
        }

        mid = (left + right) / 2

        // 含有相同元素
        if (array[left] == array[right] && array[mid] == array[left]) return orderFind(array, left, right)

        if (array[mid] >= array[left]) left = mid // 中间元素位于前面的递增数组，所以最小元素应该在数组中间的后面
        else right = mid // 中间元素位于后面的递增数组，所以最小元素应该在数组中间的前面
    }

    return array[mid]
}

private fun orderFind(array: IntArray, left: Int, right: Int): Int {
    var result = array[left]
    for (i in left + 1 until right) {
        if (array[i] < result) {
            result = array[i]
            break
        }
    }
    return result
}