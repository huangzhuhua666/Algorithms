package offer

import TreeNode

/**
 * Create by hzh on 2020/4/16.
 * 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
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

    val root = sequence[length - 1] // 二叉搜索树后序遍历数组最后一个元素必然是二叉搜索树的根

    var split = start
    while (split < length - 1) {
        if (sequence[split] > root) break // 找到数组中第一个比根结点值大的元素

        ++split
    }

    // 检查第一个比根结点值大的元素后面是否有比根结点值还要小的元素
    // 如果有，则这个数组必然不符合二叉搜索树后序遍历的序列
    var i = split
    while (i < length - 1) {
        if (sequence[i] < root) return false
        ++i
    }

    // 判断左子树
    var left = true
    if (split > start) left = verifySequenceOfBST(sequence, start, split)

    // 判断右子树
    var right = true
    if (split < i) right = verifySequenceOfBST(sequence, split, length - split - 1)

    return left && right
}