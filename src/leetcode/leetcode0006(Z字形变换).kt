package leetcode

import kotlin.math.min

/**
 * Create by hzh on 2020/4/11.
 * Z字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z字形排列。
 * 比如输入字符串为"LEETCODEISHIRING"行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 */
fun main() {
    assert(convert1("LEETCODEISHIRING", 3) == "LEETCODEISHIRING")
    println(convert1("LEETCODEISHIRING", 3))

    assert(convert2("LEETCODEISHIRING", 3) == "LEETCODEISHIRING")
    println(convert2("LEETCODEISHIRING", 3))
}

/**
 * 找规律
 *
 * 对于n行，s中第i个字符，
 * i % (2 * n - 2) == 0 --> row 0
 * i % (2 * n - 2) == 1 --> row 1
 * i % (2 * n - 2) == 2 --> row 2
 * ...
 * i % (2 * n - 2) == n - 1 --> row(n - 1)
 *
 * 对row = i % (2 * n - 2)进行判断
 * 若row <= n - 1，s[i]属于第row行
 * 否则，s[i]属于2 * n - row - 2行
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
 * 从左向右遍历s，当移动到最下行或移动到最上行的时候改变行方向
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