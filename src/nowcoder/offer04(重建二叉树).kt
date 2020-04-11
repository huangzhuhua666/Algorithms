package nowcoder

import TreeNode

/**
 * Create by hzh on 2020/3/17.
 * �ؽ�������
 *
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */
fun main() {
    val pre = intArrayOf(1, 2, 4, 7, 3, 5, 6, 8)
    val mid = intArrayOf(4, 7, 2, 1, 5, 3, 8, 6)

    reConstructBinaryTree(pre, mid)?.let { root ->
        println("ǰ�����")
        TreeNode.preOrder1(root)
        TreeNode.preOrder2(root)
        println()
        println()
        println("�������")
        TreeNode.midOrder1(root)
        TreeNode.midOrder2(root)
        println()
        println()
        println("�������")
        TreeNode.lastOrder1(root)
        TreeNode.lastOrder2(root)
        println()
    }
}

private fun reConstructBinaryTree(pre: IntArray, mid: IntArray): TreeNode? = buildCore(
        pre,
        0,
        pre.size - 1,
        mid,
        0,
        mid.size - 1
)

/**
 * �ݹ鹹��������
 */
private fun buildCore(
        pre: IntArray,
        preStart: Int,
        preEnd: Int,
        mid: IntArray,
        midStart: Int,
        midEnd: Int): TreeNode? {
    if (preStart > preEnd || midStart > midEnd) return null

    val root = TreeNode(pre[preStart]) // ǰ�������ͷ�Ǹ��ڵ�

    for (i in midStart..midEnd) {
        if (pre[preStart] == mid[i]) { // �ҵ��������������������λ�ã�����߲����������������ұ߲�����������
            root.left = buildCore(
                    pre,
                    preStart + 1,
                    preStart + i - midStart,
                    mid,
                    midStart,
                    i - 1
            ) // ����������

            root.right = buildCore(
                    pre,
                    preStart + i + 1 - midStart,
                    preEnd,
                    mid,
                    i + 1,
                    midEnd
            ) // ����������
            break
        }
    }

    return root
}