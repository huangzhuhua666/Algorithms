package leetcode

/**
 * Create by hzh on 2024/2/29.
 * ����ܺ�
 *
 * ����һ�� ���ظ�Ԫ�� ���������� candidates ��һ��Ŀ������ target ��
 * �ҳ� candidates �п���ʹ���ֺ�ΪĿ���� target �� ���� ��ͬ��� �������б���ʽ���ء�
 * ����԰� ����˳�� ������Щ��ϡ�
 * candidates �е� ͬһ�� ���ֿ��� �������ظ���ѡȡ ��
 * �������һ�����ֵı�ѡ������ͬ������������ǲ�ͬ�ġ�
 * ���ڸ��������룬��֤��Ϊ target �Ĳ�ͬ��������� 150 ����
 *
 * ʾ�� 1��
 * ���룺candidates = [2,3,6,7], target = 7
 * �����[[2,2,3],[7]]
 * ���ͣ�
 * 2 �� 3 �����γ�һ���ѡ��2 + 2 + 3 = 7 ��ע�� 2 ����ʹ�ö�Ρ�
 * 7 Ҳ��һ����ѡ�� 7 = 7 ��
 * ������������ϡ�
 *
 * ʾ�� 2��
 * ����: candidates = [2,3,5], target = 8
 * ���: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * ʾ�� 3��
 * ����: candidates = [2], target = 1
 * ���: []
 */
fun main() {
    println(combinationSum(intArrayOf(2, 3, 6, 7), 7))
    println(combinationSum(intArrayOf(2, 3, 5), 8))
    println(combinationSum(intArrayOf(2), 1))
}

private val RESULT = mutableListOf<List<Int>>()
private val LIST = mutableListOf<Int>()

private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
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
        val num = candidates[i]
        if (num <= target) {
            LIST.add(num)
            backtrack(candidates, target - num, i)
            LIST.removeAt(LIST.lastIndex)
        }
    }
}