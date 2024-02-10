package leetcode

import KMP

/**
 * Create by hzh on 2024/2/9.
 * �ҳ��ַ����е�һ��ƥ������±�
 *
 * ���������ַ��� haystack �� needle ��
 * ������ haystack �ַ������ҳ� needle �ַ����ĵ�һ��ƥ������±꣨�±�� 0 ��ʼ����
 * ��� needle ���� haystack ��һ���֣��򷵻�  -1 ��
 *
 * ʾ�� 1��
 * ���룺haystack = "sadbutsad", needle = "sad"
 * �����0
 * ���ͣ�"sad" ���±� 0 �� 6 ��ƥ�䡣
 * ��һ��ƥ������±��� 0 �����Է��� 0 ��
 *
 * ʾ�� 2��
 * ���룺haystack = "leetcode", needle = "leeto"
 * �����-1
 * ���ͣ�"leeto" û���� "leetcode" �г��֣����Է��� -1 ��
 */
fun main() {
    println(strStr1("sadbutsad", "sad"))
    println(strStr1("leetcode", "leeto"))
    println(strStr2("sadbutsad", "sad"))
    println(strStr2("leetcode", "leeto"))
    println(strStr3("sadbutsad", "sad"))
    println(strStr3("leetcode", "leeto"))
}

/**
 * ���Ѷȣ�����ֱ���ÿ�
 */
private fun strStr1(haystack: String, needle: String): Int {
    return haystack.indexOf(needle)
}

/**
 * ������
 */
private fun strStr2(haystack: String, needle: String): Int {
    if (haystack.isEmpty() || needle.isEmpty()) {
        return -1
    }

    val patLen = needle.length
    for (i in 0..haystack.length - patLen) {
        var match = true
        for (j in 0 until patLen) {
            if (haystack[i + j] != needle[j]) {
                match = false
                break
            }
        }

        if (match) {
            return i
        }
    }

    return -1
}

/**
 * KMP:[https://zhuanlan.zhihu.com/p/83334559]
 */
private fun strStr3(haystack: String, needle: String): Int {
    if (haystack.isEmpty() || needle.isEmpty()) {
        return -1
    }

    return KMP(needle).search(haystack)
}