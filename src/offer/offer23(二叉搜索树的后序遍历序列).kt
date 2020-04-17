package offer

import TreeNode

/**
 * Create by hzh on 2020/4/16.
 * �����������ĺ����������
 *
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No��
 * �������������������������ֶ�������ͬ��
 */
fun main() {
    TreeNode.lastOrder1(TreeNode(12).apply {
        left = TreeNode(5).apply {
            left = TreeNode(2)
            right = TreeNode(9)
        }
        right = TreeNode(18).apply {
            left = TreeNode(15).apply {
                right = TreeNode(17).apply {
                    left = TreeNode(16)
                }
            }
            right = TreeNode(19)
        }
    })

    println(verifySequenceOfBST(intArrayOf(2, 9, 5, 16, 17, 15, 19, 18, 12)))
}

private fun verifySequenceOfBST(sequence: IntArray): Boolean {
    return verifySequenceOfBST(sequence, 0, sequence.size)
}

private fun verifySequenceOfBST(sequence: IntArray, start: Int, length: Int): Boolean {
    if (length <= 0) return false

    val root = sequence[length - 1] // ������������������������һ��Ԫ�ر�Ȼ�Ƕ����������ĸ�

    var split = start
    while (split < length - 1) {
        if (sequence[split] > root) break // �ҵ������е�һ���ȸ����ֵ���Ԫ��

        ++split
    }

    // ����һ���ȸ����ֵ���Ԫ�غ����Ƿ��бȸ����ֵ��ҪС��Ԫ��
    // ����У�����������Ȼ�����϶����������������������
    var i = split
    while (i < length - 1) {
        if (sequence[i] < root) return false
        ++i
    }

    // �ж�������
    var left = true
    if (split > start) left = verifySequenceOfBST(sequence, start, split)

    // �ж�������
    var right = true
    if (split < i) right = verifySequenceOfBST(sequence, split, length - split - 1)

    return left && right
}