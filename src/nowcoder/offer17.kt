package nowcoder

import TreeNode

/**
 * Create by hzh on 2020/3/26.
 */
fun main() {
    val tree = TreeNode(8).apply {
        left = TreeNode(6).apply {
            left = TreeNode(5)
            right = TreeNode(7)
        }
        right = TreeNode(10).apply {
            left = TreeNode(9)
            right = TreeNode(11)
        }
    }
    TreeNode.preOrder1(tree)
}

private fun hasSubtree(root1: TreeNode?, root2: TreeNode?): Boolean {
    var result = false
//    if (root1 != null && root2 != null) {
//        if (root1.value == root2.value)
//    }
    return result
}