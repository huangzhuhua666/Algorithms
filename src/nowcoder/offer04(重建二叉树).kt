package nowcoder

import TreeNode

/**
 * Create by hzh on 2020/3/17.
 * 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
fun main() {
    val pre = intArrayOf(1, 2, 4, 7, 3, 5, 6, 8)
    val mid = intArrayOf(4, 7, 2, 1, 5, 3, 8, 6)

    reConstructBinaryTree(pre, mid)?.let { root ->
        println("前序遍历")
        TreeNode.preOrder1(root)
        TreeNode.preOrder2(root)
        println()
        println()
        println("中序遍历")
        TreeNode.midOrder1(root)
        TreeNode.midOrder2(root)
        println()
        println()
        println("后序遍历")
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
 * 递归构建二叉树
 */
private fun buildCore(
        pre: IntArray,
        preStart: Int,
        preEnd: Int,
        mid: IntArray,
        midStart: Int,
        midEnd: Int): TreeNode? {
    if (preStart > preEnd || midStart > midEnd) return null

    val root = TreeNode(pre[preStart]) // 前序遍历开头是根节点

    for (i in midStart..midEnd) {
        if (pre[preStart] == mid[i]) { // 找到根结点在中序遍历数组的位置，其左边部分是左子树，其右边部分是右子树
            root.left = buildCore(
                    pre,
                    preStart + 1,
                    preStart + i - midStart,
                    mid,
                    midStart,
                    i - 1
            ) // 构建左子树

            root.right = buildCore(
                    pre,
                    preStart + i + 1 - midStart,
                    preEnd,
                    mid,
                    i + 1,
                    midEnd
            ) // 构建右子树
            break
        }
    }

    return root
}