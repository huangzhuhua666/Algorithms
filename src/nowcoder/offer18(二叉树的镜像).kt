package nowcoder

import TreeNode

/**
 * Create by hzh on 2020/4/15.
 * 二叉树的镜像
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
fun main() {
    val root = TreeNode(8).apply {
        left = TreeNode(6).apply {
            left = TreeNode(5)
            right = TreeNode(7)
        }
        right = TreeNode(10).apply {
            left = TreeNode(9)
            right = TreeNode(11)
        }
    }
    TreeNode.preOrder1(root)

    mirror(root)

    TreeNode.preOrder1(root)
}

private fun mirror(root: TreeNode?) {
    root?.run {
        val tmp = left
        left = right
        right = tmp

        left?.let { mirror(it) }

        right?.let { mirror(it) }
    }
}