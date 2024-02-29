package leetcode

/**
 * Create by hzh on 2024/2/29.
 * 组合总和II
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
fun main() {
    println(combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
    println(combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
}

private val RESULT = mutableListOf<List<Int>>()
private val LIST = mutableListOf<Int>()

private fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    RESULT.clear()
    LIST.clear()
    candidates.sort()

    backtrack(candidates, target, 0)

    return RESULT
}

private fun backtrack(candidates: IntArray, target: Int, index: Int) {
    if (target == 0 && LIST.isNotEmpty()) {
        RESULT.add(LIST.toList())
        return
    }

    for (i in index until candidates.size) {
        if (i > index && candidates[i] == candidates[i - 1]) {
            continue
        }

        val num = candidates[i]
        if (num <= target) {
            LIST.add(num)
            backtrack(candidates, target - num, i + 1)
            LIST.removeAt(LIST.lastIndex)
        }
    }
}