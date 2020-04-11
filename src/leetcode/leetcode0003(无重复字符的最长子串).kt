package leetcode

import no
import yes
import kotlin.math.max

/**
 * Create by hzh on 2020/4/10.
 * ���ظ��ַ�����Ӵ�
 *
 * ����һ���ַ����������ҳ����в������ظ��ַ�����Ӵ��ĳ��ȡ�
 */
fun main() {
    println(lengthOfLongestSubString("abcabcbb"))
}

private fun lengthOfLongestSubString(s: String): Int = when (s.length < 2) {
    true -> s.length
    false -> {
        if (s.length == 2) (s[0] == s[1]).yes { 1 }.no { 2 }
        else {
            var result = -1
            val map = mutableMapOf<Char, Int>()

            var index = 0
            while (index < s.length) {
                val c = s[index]
                if (map.containsKey(c)) {
                    index = map[c]!!
                    map.clear()
                } else {
                    map[c] = index
                    result = max(result, map.size)
                }

                ++index
            }

            result
        }
    }
}