package offer

import TreeNode

/**
 * Create by hzh on 2020/4/20.
 * 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
fun main() {
    val root = TreeNode(12).apply {
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
    }

    var head = convert(root)
    while (head != null) {
        print("${head.value}\t")
        head = head.right
    }
    println()
}

private fun convert(root: TreeNode?): TreeNode? = if (root == null) null
else {
    convertCore(root)

    var head = root

    while (head?.left != null) { // 找到最左的结点
        head = head.left
    }

    head
}

/**
 * 标记前一个结点
 */
private var lastNode: TreeNode? = null

private fun convertCore(node: TreeNode?) {
    node?.let {
        it.left?.run { convertCore(this) }

        it.left = lastNode

        lastNode?.run { this.right = it } // 标记前一个结点的后继结点为当前结点
        lastNode = it

        it.right?.run { convertCore(this) }
    }
}