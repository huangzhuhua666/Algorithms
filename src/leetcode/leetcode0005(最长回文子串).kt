package leetcode

/**
 * Create by hzh on 2020/4/10.
 * ������Ӵ�
 *
 * ����һ���ַ���s���ҵ�s����Ļ����Ӵ�������Լ���s����󳤶�Ϊ 1000��
 */
fun main() {
    println(longestPalindrome1("babad"))
    println(longestPalindrome2("babad"))
}

/**
 * �м���ɢ��
 * ��ĳһ�ַ�����ʼ�����������ֱ���Ҳ���������ͬ���ַ�����¼left
 * �����ұ���ֱ���Ҳ���������ͬ���ַ�����¼right
 * �����ͬʱ�������ұ���ֱ�������ַ�����ͬ����¼left��right��len
 * ���len > maxLen����¼��ʱ��maxStart = left + 1
 */
private fun longestPalindrome1(s: String): String = when (s.length) {
    0 -> ""
    1 -> s
    else -> {
        var maxLen = 1
        var maxStart = 0

        for (i in s.indices) {
            var len = 1
            var left = i - 1
            var right = i + 1

            while (left > 0 && s[left] == s[i]) { // ���������ֱ��û��������ͬ���ַ�
                ++len
                --left
            }

            while (right < s.length && s[right] == s[i]) { // ���ұ�����ֱ��û��������ͬ���ַ�
                ++len
                ++right
            }

            // ͬʱ����������ɢ������ֱ�������ַ�����ͬ
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                len += 2
                --left
                ++right
            }

            if (len > maxLen) {
                maxLen = len
                maxStart = left + 1
            }
        }

        s.substring(maxStart, maxStart + maxLen)
    }
}

/**
 * ��̬�滮��
 * ��dp[left][right]��ʾ��left-right�Ƿ�Ϊ���Ĵ�
 * ��dp[left][right] = true��
 * ��Ҫ�ж�dp[left - 1][right + 1]�Ƿ�Ϊ���Ĵ���ֻ���ж�left - 1��right + 1���ַ��Ƿ���ͬ����
 */
private fun longestPalindrome2(s: String): String = when (s.length) {
    0 -> ""
    1 -> s
    else -> {
        val dp = Array(s.length) { out -> BooleanArray(s.length) { it == out } }

        var maxLen = 1
        var maxStart = 0

        for (right in 1 until s.length) {
            for (left in 0 until right) {
                if (s[left] == s[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true

                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1
                        maxStart = left
                    }
                }
            }
        }

        s.substring(maxStart, maxStart + maxLen)
    }
}