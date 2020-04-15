package nowcoder

import TreeNode

/**
 * Create by hzh on 2020/3/26.
 * 树的子结构
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
fun main() {
    val tree1 = TreeNode(8).apply {
        left = TreeNode(6).apply {
            left = TreeNode(5)
            right = TreeNode(7)
        }
        right = TreeNode(10).apply {
            left = TreeNode(9)
            right = TreeNode(11)
        }
    }
    TreeNode.preOrder1(tree1)

    val tree2 = TreeNode(10).apply {
        left = TreeNode(9)
        right = TreeNode(11)
    }
    TreeNode.preOrder1(tree2)

    println(hasSubtree(tree1, tree2))
}

private fun hasSubtree(root1: TreeNode?, root2: TreeNode?): Boolean {
    var result = false
    if (root1 != null && root2 != null) { // 空树不是任意一个树的子结构
        // 根结点的值相同，检测树A是否包含树B
        if (root1.value == root2.value) result = isTree1ContainTree2(root1, root2)

        // 根结点的值不同，往左子树作为树A搜索
        if (!result) result = hasSubtree(root1.left, root2)

        // 根结点的值不同，且左子树不包含树B，往右子树作为树A搜索
        if (!result) result = hasSubtree(root1.right, root2)
    }
    return result
}

/**
 * 检测树A是否包含树B
 */
private fun isTree1ContainTree2(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root2 == null) return true // 树B为空，树A可能包含树B，需要往右子树搜索

    if (root1 == null) return false // 树B不为空，但树A为空，这时A不可能包含B

    if (root1.value != root2.value) return false // 根结点值不同，直接返回false

    return isTree1ContainTree2(root1.left, root2.left) && isTree1ContainTree2(root1.right, root2.right)
}