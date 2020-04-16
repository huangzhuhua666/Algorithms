package leetcode

import kotlin.math.min

/**
 * Create by hzh on 2020/4/11.
 * Z���α任
 *
 * ��һ�������ַ������ݸ������������Դ������¡������ҽ���Z�������С�
 * ���������ַ���Ϊ"LEETCODEISHIRING"����Ϊ 3 ʱ���������£�
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * ֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��
 * ����ʵ��������ַ�������ָ�������任�ĺ�����
 */
fun main() {
    assert(convert1("LEETCODEISHIRING", 3) == "LEETCODEISHIRING")
    println(convert1("LEETCODEISHIRING", 3))

    assert(convert2("LEETCODEISHIRING", 3) == "LEETCODEISHIRING")
    println(convert2("LEETCODEISHIRING", 3))
}

/**
 * �ҹ���
 *
 * ����n�У�s�е�i���ַ���
 * i % (2 * n - 2) == 0 --> row 0
 * i % (2 * n - 2) == 1 --> row 1
 * i % (2 * n - 2) == 2 --> row 2
 * ...
 * i % (2 * n - 2) == n - 1 --> row(n - 1)
 *
 * ��row = i % (2 * n - 2)�����ж�
 * ��row <= n - 1��s[i]���ڵ�row��
 * ����s[i]����2 * n - row - 2��
 */
private fun convert1(s: String, numRows: Int): String = when {
    s == "" || numRows == 0 -> ""
    numRows == 1 -> s
    else -> {
        val array = Array(min(numRows, s.length)) { StringBuilder() }

        s.forEachIndexed { index, c ->
            val row = index % (2 * numRows - 2)
            array[if (row <= numRows - 1) row else 2 * numRows - row - 2].append(c)
        }

        array.reduce { acc, stringBuilder ->
            acc.append(stringBuilder)
        }.toString()
    }
}

/**
 * �������ұ���s�����ƶ��������л��ƶ��������е�ʱ��ı��з���
 */
private fun convert2(s: String, numRows: Int): String = when {
    s == "" || numRows == 0 -> ""
    numRows == 1 -> s
    else -> {
        val array = Array(min(numRows, s.length)) { StringBuilder() }

        var currRow = 0
        var isGoDown = false

        s.forEach {
            array[currRow].append(it)

            if (currRow == 0 || currRow == array.size - 1) isGoDown = !isGoDown

            currRow += if (isGoDown) 1 else -1
        }

        array.reduce { acc, stringBuilder ->
            acc.append(stringBuilder)
        }.toString()
    }
}