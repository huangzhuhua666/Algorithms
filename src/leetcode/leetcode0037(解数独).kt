package leetcode

import print

/**
 * Create by hzh on 2024/2/28.
 * ������
 *
 * ��дһ������ͨ�����ո�������������⡣
 * �����Ľⷨ�� ��ѭ���¹���
 * ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * ���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�����ο�ʾ��ͼ��
 * �������ֿո��������������֣��հ׸��� '.' ��ʾ��
 *
 * ʾ�� 1��
 * ���룺board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * �����
 * [["5","3","4","6","7","8","9","1","2"]
 * ,["6","7","2","1","9","5","3","4","8"]
 * ,["1","9","8","3","4","2","5","6","7"]
 * ,["8","5","9","7","6","1","4","2","3"]
 * ,["4","2","6","8","5","3","7","9","1"]
 * ,["7","1","3","9","2","4","8","5","6"]
 * ,["9","6","1","5","3","7","2","8","4"]
 * ,["2","8","7","4","1","9","6","3","5"]
 * ,["3","4","5","2","8","6","1","7","9"]]
 */
fun main() {
    solveSudoku(arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )).forEach {
        it.print()
    }
}

private val ROWS = Array(9) { BooleanArray(9) }
private val COLUMNS = Array(9) { BooleanArray(9) }
private val SUB_BOX = Array(3) { Array(3) { BooleanArray(9) } }
private val SPACES = mutableListOf<Pair<Int, Int>>()
private var isSolve = false

private fun solveSudoku(board: Array<CharArray>): Array<CharArray> {
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            val char = board[i][j]
            if (char == '.') {
                SPACES.add(i to j)
                continue
            }

            val digit = char - '0' - 1
            setRecord(i, j, digit, true)
        }
    }

    backtrack(board, 0)

    return board
}

private fun setRecord(i: Int, j: Int, digit: Int,record: Boolean) {
    ROWS[i][digit] = record
    COLUMNS[j][digit] = record
    SUB_BOX[i / 3][j / 3][digit] = record
}

private fun backtrack(board: Array<CharArray>, position: Int) {
    if (position == SPACES.size) {
        isSolve = true
        return
    }

    val (i, j) = SPACES[position]
    var digit = 0
    while (digit < 9 && !isSolve) {
        if (!ROWS[i][digit] && !COLUMNS[j][digit] && !SUB_BOX[i / 3][j / 3][digit]) {
            setRecord(i, j, digit, true)

            board[i][j] = '0' + digit + 1

            backtrack(board, position + 1)

            setRecord(i, j, digit, false)
        }

        ++digit
    }
}