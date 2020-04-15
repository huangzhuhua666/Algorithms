package nowcoder

import TreeNode

/**
 * Create by hzh on 2020/3/26.
 * �����ӽṹ
 *
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
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
    if (root1 != null && root2 != null) { // ������������һ�������ӽṹ
        // ������ֵ��ͬ�������A�Ƿ������B
        if (root1.value == root2.value) result = isTree1ContainTree2(root1, root2)

        // ������ֵ��ͬ������������Ϊ��A����
        if (!result) result = hasSubtree(root1.left, root2)

        // ������ֵ��ͬ������������������B������������Ϊ��A����
        if (!result) result = hasSubtree(root1.right, root2)
    }
    return result
}

/**
 * �����A�Ƿ������B
 */
private fun isTree1ContainTree2(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root2 == null) return true // ��BΪ�գ���A���ܰ�����B����Ҫ������������

    if (root1 == null) return false // ��B��Ϊ�գ�����AΪ�գ���ʱA�����ܰ���B

    if (root1.value != root2.value) return false // �����ֵ��ͬ��ֱ�ӷ���false

    return isTree1ContainTree2(root1.left, root2.left) && isTree1ContainTree2(root1.right, root2.right)
}