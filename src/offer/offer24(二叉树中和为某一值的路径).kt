package offer

import TreeNode

/**
 * Create by hzh on 2020/4/17.
 * 二叉树中和为某一值的路径
 *
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * (再注意：一定要从根结点出发，遍历到叶子节点)
 */
private val list = mutableListOf<MutableList<Int>>()
private val subList = mutableListOf<Int>()

fun main() {
    val root = TreeNode(8).apply {
        left = TreeNode(6).apply {
            left = TreeNode(4)
            right = TreeNode(7)
        }
        right = TreeNode(10).apply {
            left = TreeNode(0)
            right = TreeNode(11)
        }
    }
    findPath(root, 18)

    list.forEach { sub ->
        sub.forEach { print("$it\t") }
        println()
    }
}

private fun findPath(root: TreeNode?, target: Int) {
    if (root == null) return

    subList.add(root.value)
    val currTarget = target - root.value
    if (currTarget == 0 && root.left == null && root.right == null) list.add(ArrayList(subList))

    root.left?.let { findPath(it, currTarget) }
    root.right?.let { findPath(it, currTarget) }
    subList.removeAt(subList.size - 1)
}