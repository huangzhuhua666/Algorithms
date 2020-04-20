import java.util.*

/**
 * Create by hzh on 2020/4/20.
 * ��������������������
 */
private lateinit var nodes: Array<Node>

private class Node(val weight: Int, var left: Node? = null, var right: Node? = null)
    : Comparable<Node> {

    var code: String = ""

    override fun compareTo(other: Node): Int = weight.compareTo(other.weight)
}

fun main() {
    val chars = charArrayOf('A', 'B', 'C', 'D', 'E', 'F') // �ַ���
    val weights = intArrayOf(2, 3, 7, 9, 18, 25) // ��Ӧ�ַ����ַ����ֵĴ���

    val root = createHuffmanTree(weights) // ����һ����������
    encode(root)

    for (i in chars.indices) {
        println("${chars[i]} -> ${nodes[i].code}")
    }
}

/**
 * ����Ȩ�ع�����������
 */
private fun createHuffmanTree(weights: IntArray): Node {
    // ��С���ȶ��У���������������������
    val nodeQueue: Queue<Node> = PriorityQueue<Node>()

    // ����ɭ�ֽ�㣬�����뵽���ȶ�����
    nodes = Array(weights.size) { Node(weights[it]).also { node -> nodeQueue.offer(node) } }

    while (nodeQueue.size > 1) {
        // ѡ�����ȶ�����Ȩ��ֵ��С���������
        val left = nodeQueue.poll()
        val right = nodeQueue.poll()

        // ��������������Ȩ�غ͹���һ�����ڵ㣬�����뵽���ȶ�����
        Node(left.weight + right.weight, left, right).also { nodeQueue.offer(it) }
    }

    return nodeQueue.poll()
}

private fun encode(root: Node?, code: String = "") {
    root?.let {
        it.code = code

        encode(it.left, "${code}0") // ���֧��'0'
        encode(it.right, "${code}1") // �ҷ�֧��'1'
    }
}