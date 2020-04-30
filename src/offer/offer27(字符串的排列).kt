package offer

import swap

/**
 * Create by hzh on 2020/4/27.
 * �ַ���������
 *
 * ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 */
private val list = mutableListOf<String>()

fun main() {
    permutation("abc")
    list.forEach(::println)
}

private fun permutation(str: String) {
    list.clear()
    if (str.isEmpty()) return

    permutationCore(str.toCharArray(), 0)
    list.sort()
}

private fun permutationCore(chars: CharArray, start: Int) {
    if (start == chars.size - 1) String(chars).let { if (!list.contains(it)) list.add(it) }
    else {
        for (i in chars.indices) {
            chars.swap(start, i)
            permutationCore(chars, start + 1)
            chars.swap(start, i) // ��Ҫ��λ
        }
    }
}