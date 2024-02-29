package leetcode

/**
 * Create by hzh on 2024/2/29.
 * ����ܺ�II
 *
 * ����һ����ѡ�˱�ŵļ��� candidates ��һ��Ŀ���� target ��
 * �ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 * candidates �е�ÿ��������ÿ�������ֻ��ʹ�� һ�� ��
 * ע�⣺�⼯���ܰ����ظ�����ϡ�
 *
 * ʾ�� 1:
 * ����: candidates = [10,1,2,7,6,1,5], target = 8,
 * ���:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * ʾ�� 2:
 * ����: candidates = [2,5,2,1,2], target = 5,
 * ���:
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