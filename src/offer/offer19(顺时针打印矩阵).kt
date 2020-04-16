package offer

/**
 * Create by hzh on 2020/4/16.
 * ˳ʱ���ӡ����
 *
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������.
 * ���磬�����������4 X 4����1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
fun main() {
    printMatrix(arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
    ))

    printMatrix(arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(16, 17, 18, 19, 20),
            intArrayOf(21, 22, 23, 24, 25)
    ))

    printMatrix(arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15)
    ))

    printMatrix(arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
            intArrayOf(10, 11, 12)
    ))
}

private fun printMatrix(matrix: Array<IntArray>) {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return

    var start = 0
    val rows = matrix.size
    val cols = matrix[0].size

    while (rows > 2 * start && cols > 2 * start) {
        val endRow = rows - start - 1
        val endCol = cols - start - 1

        for (i in start..endCol) { // ������
            print("${matrix[start][i]}\t")
        }

        if (start < endRow) {
            for (i in start + 1..endRow) { // ���ϵ���
                print("${matrix[i][endCol]}\t")
            }
        }

        if (start < endCol && start < endRow) {
            for (i in endCol - 1 downTo start) { // ���ҵ���
                print("${matrix[endRow][i]}\t")
            }
        }

        if (start < endCol && start < endRow - 1) {
            for (i in endRow - 1 downTo start + 1) { // ���µ���
                print("${matrix[i][start]}\t")
            }
        }

        ++start
    }
    println()
}