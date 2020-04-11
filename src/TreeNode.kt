import java.util.*

/**
 * Create by hzh on 2020/3/17.
 */
class TreeNode(val value: Int) {

    companion object {

        /**
         * ǰ������ǵݹ�
         */
        fun preOrder1(root: TreeNode) {
            val stack = Stack<TreeNode>()
            stack.push(root)

            while (!stack.isEmpty()) {
                val node = stack.pop()
                print("${node.value} ")

                node.right?.let { stack.push(it) }
                node.left?.let { stack.push(it) }
            }

            println()
        }

        /**
         * ǰ������ݹ�
         */
        fun preOrder2(root: TreeNode?) {
            if (root == null) return

            print("${root.value} ")
            preOrder2(root.left)
            preOrder2(root.right)
        }

        /**
         * ��������ǵݹ�
         */
        fun midOrder1(root: TreeNode) {
            val stack = Stack<TreeNode>()

            var node: TreeNode? = root
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node)
                    node = node.left
                }

                node = stack.pop()
                print("${node.value} ")
                node = node.right
            }

            println()
        }

        /**
         * ��������ݹ�
         */
        fun midOrder2(root: TreeNode?) {
            if (root == null) return

            midOrder2(root.left)
            print("${root.value} ")
            midOrder2(root.right)
        }

        /**
         * ��������ǵݹ�
         */
        fun lastOrder1(root: TreeNode) {
            val stack = Stack<TreeNode>()

            var node: TreeNode? = root
            var pre: TreeNode? = null
            while (node != null || !stack.isEmpty()) {
                if (node != null) {
                    stack.push(node)
                    node = node.left
                } else {
                    node = stack.pop()
                    if (node!!.right == null || node.right == pre) {
                        print("${node.value} ")
                        pre = node
                        node = null
                    } else {
                        stack.push(node)
                        node = node.right
                    }
                }
            }

            println()
        }

        /**
         * ��������ݹ�
         */
        fun lastOrder2(root: TreeNode?) {
            if (root == null) return

            lastOrder2(root.left)
            lastOrder2(root.right)
            print("${root.value} ")
        }
    }

    var left: TreeNode? = null

    var right: TreeNode? = null
}