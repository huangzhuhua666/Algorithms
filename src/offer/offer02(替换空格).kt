package offer

/**
 * Create by hzh on 2020/3/17.
 * �滻�ո�
 *
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
fun main() {
    println(replaceSpace1(StringBuffer("We Are Happy")))
    println(replaceSpace2(StringBuffer("We Are Happy")))
}

/**
 * ����һ
 * ֱ���½�һ��StringBuffer�������ɵ�StringBuffer�������ո��append("%20")
 */
private fun replaceSpace1(str: StringBuffer): String = StringBuffer().run {
    str.forEach { c -> append(if (c == ' ') "%20" else c) }
    toString()
}

/**
 * ������
 * ��ԭStringBuffer�������޸�
 */
private fun replaceSpace2(str: StringBuffer): String = str.run {
    var spaceCount = 0
    forEach { c -> if (c == ' ') ++spaceCount } // ͳ�ƿո�����

    val oldLen = length
    setLength(oldLen + spaceCount * 2) // �µ����� = ԭ���� + �ո��� * 2

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