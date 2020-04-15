package offer

/**
 * Create by hzh on 2020/3/17.
 * 替换空格
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
fun main() {
    println(replaceSpace1(StringBuffer("We Are Happy")))
    println(replaceSpace2(StringBuffer("We Are Happy")))
}

/**
 * 方法一
 * 直接新建一个StringBuffer，遍历旧的StringBuffer，遇到空格就append("%20")
 */
private fun replaceSpace1(str: StringBuffer): String = StringBuffer().run {
    str.forEach { c -> append(if (c == ' ') "%20" else c) }
    toString()
}

/**
 * 方法二
 * 在原StringBuffer上扩容修改
 */
private fun replaceSpace2(str: StringBuffer): String = str.run {
    var spaceCount = 0
    forEach { c -> if (c == ' ') ++spaceCount } // 统计空格数量

    val oldLen = length
    setLength(oldLen + spaceCount * 2) // 新的容量 = 原容量 + 空格数 * 2

    for (i in oldLen - 1 downTo 0) {
        var currIndex = i + spaceCount * 2

        if (str[i] == ' ') {
            str.setCharAt(currIndex--, '0')
            str.setCharAt(currIndex--, '2')
            str.setCharAt(currIndex, '%')
            --spaceCount
        } else str.setCharAt(currIndex, str[i])
    }

    toString()
}