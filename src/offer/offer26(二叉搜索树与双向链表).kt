package offer

import TreeNode

/**
 * Create by hzh on 2020/4/20.
 * ������������˫������
 *
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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

    while (head?.left != null) { // �ҵ�����Ľ��
        head = head.left
    }

    head
}

/**
 * ���ǰһ�����
 */
private var lastNode: TreeNode? = null

private fun convertCore(node: TreeNode?) {
    node?.let {
        it.left?.run { convertCore(this) }

        it.left = lastNode

        lastNode?.run { this.right = it } // ���ǰһ�����ĺ�̽��Ϊ��ǰ���
        lastNode = it

        it.right?.run { convertCore(this) }
    }
}