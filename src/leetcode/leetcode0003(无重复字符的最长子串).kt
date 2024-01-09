package leetcode

import kotlin.math.max

/**
 * Create by hzh on 2020/4/10.
 * ���ظ��ַ�����Ӵ�
 *
 * ����һ���ַ����������ҳ����в������ظ��ַ�����Ӵ��ĳ��ȡ�
 */
fun main() {
    println(lengthOfLongestSubString("abcabcbb"))
    println(lengthOfLongestSubString("bbbbb"))
    println(lengthOfLongestSubString("pwwkew"))
    println(lengthOfLongestSubString(" "))
    println(lengthOfLongestSubString(""))
    println(lengthOfLongestSubString("a"))
    println(lengthOfLongestSubString("au"))
    println(lengthOfLongestSubString("tmmzuxt"))
}

/**
 * �������ڣ����map�и��ַ��ļ�¼���򻬶����ڵ�left��Ҫ���ƣ�ע�ⲻҪ��left�����ˣ���������"tmmzuxt"�������
 */
private fun lengthOfLongestSubString(s: String): Int {
    var result = 0
    val map = mutableMapOf<Char, Int>()

    var left = 0
    s.forEachIndexed { index, c ->
        if (map.containsKey(c)) {
            left = max(left, (map[c] ?: 0) + 1)
        }

        map[c] = index

        result = max(result, index - left + 1)
    }

    return result
}