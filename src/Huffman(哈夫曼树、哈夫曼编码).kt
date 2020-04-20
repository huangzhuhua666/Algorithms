import java.util.*

/**
 * Create by hzh on 2020/4/20.
 * 哈夫曼树、哈夫曼编码
 */
private lateinit var nodes: Array<Node>

private class Node(val weight: Int, var left: Node? = null, var right: Node? = null)
    : Comparable<Node> {

    var code: String = ""

    override fun compareTo(other: Node): Int = weight.compareTo(other.weight)
}

fun main() {
    val chars = charArrayOf('A', 'B', 'C', 'D', 'E', 'F') // 字符集
    val weights = intArrayOf(2, 3, 7, 9, 18, 25) // 对应字符集字符出现的次数

    val root = createHuffmanTree(weights) // 构建一个哈夫曼树
    encode(root)

    for (i in chars.indices) {
        println("${chars[i]} -> ${nodes[i].code}")
    }
}

/**
 * 根据权重构建哈夫曼树
 */
private fun createHuffmanTree(weights: IntArray): Node {
    // 最小优先队列，用来辅助构建哈夫曼树
    val nodeQueue: Queue<Node> = PriorityQueue<Node>()

    // 创建森林结点，并加入到优先队列中
    nodes = Array(weights.size) { Node(weights[it]).also { node -> nodeQueue.offer(node) } }

    while (nodeQueue.size > 1) {
        // 选择优先队列中权重值最小的两个结点
        val left = nodeQueue.poll()
        val right = nodeQueue.poll()

        // 根据这两个结点的权重和构建一个父节点，并加入到优先队列中
        Node(left.weight + right.weight, left, right).also { nodeQueue.offer(it) }
    }

    return nodeQueue.poll()
}

private fun encode(root: Node?, code: String = "") {
    root?.let {
        it.code = code

        encode(it.left, "${code}0") // 左分支加'0'
        encode(it.right, "${code}1") // 右分支加'1'
    }
}