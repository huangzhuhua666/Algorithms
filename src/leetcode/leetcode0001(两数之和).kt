package leetcode

/**
 * Create by hzh on 2020/4/10.
 * 两数之和
 *
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
fun main() {
    twoSum(intArrayOf(-3, 4, 3, 90), 0).forEach(::println)
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, i ->
        if (map.containsKey(target - i)) {
            result[0] = map[target - i]!!
            result[1] = index
        } else map[i] = index
    }

    return result
}