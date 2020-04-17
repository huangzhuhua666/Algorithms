package offer

import TreeNode

/**
 * Create by hzh on 2020/4/17.
 * �������к�Ϊĳһֵ��·��
 *
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 * (��ע�⣺һ��Ҫ�Ӹ���������������Ҷ�ӽڵ�)
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