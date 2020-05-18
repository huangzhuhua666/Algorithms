package offer

/**
 * Create by hzh on 2020/5/18.
 * ��һ��ֻ����һ�ε��ַ�
 *
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��,
 * ���û���򷵻� -1����Ҫ���ִ�Сд��.����0��ʼ������
 */
fun main() {
    println(firstNoRepeatingChar("abcdadbc"))
}

private fun firstNoRepeatingChar(str: String?): Int = if (str == null || str.trim().isEmpty()) -1
else {
    val count = mutableMapOf<Char, Int>()

    str.forEach { count[it] = if (count.containsKey(it)) count[it]!! + 1 else 1 }

    str.forEachIndexed { index, c -> if (count[c] == 1) return index }

    -1
}