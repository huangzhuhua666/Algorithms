package offer

import TreeNode
import java.util.*

/**
 * Create by hzh on 2020/4/16.
 * 从上往下打印二叉树
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
    printFromTopToBottom(root)
}

private fun printFromTopToBottom(root: TreeNode?) {
    root?.let {
        val queue = LinkedList<TreeNode>()
        queue.offer(it)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            print("${node.value}\t")

            node.left?.let { left -> queue.offer(left) }
            node.right?.let { right -> queue.offer(right) }
        }

        println()
    }
}