package leetcode

/**
 * Create by hzh on 2024/3/6.
 * ͨ���ƥ��
 *
 * ����һ�������ַ��� (s) ��һ���ַ�ģʽ (p) ������ʵ��һ��֧�� '?' �� '*' ƥ������ͨ���ƥ�䣺
 * '?' ����ƥ���κε����ַ���
 * '*' ����ƥ�������ַ����У��������ַ����У���
 * �ж�ƥ��ɹ��ĳ�Ҫ�����ǣ��ַ�ģʽ�����ܹ� ��ȫƥ�� �����ַ����������ǲ���ƥ�䣩��
 *
 * ʾ�� 1��
 * ���룺s = "aa", p = "a"
 * �����false
 * ���ͣ�"a" �޷�ƥ�� "aa" �����ַ�����
 *
 * ʾ�� 2��
 * ���룺s = "aa", p = "*"
 * �����true
 * ���ͣ�'*' ����ƥ�������ַ�����
 *
 * ʾ�� 3��
 * ���룺s = "cb", p = "?a"
 * �����false
 * ���ͣ�'?' ����ƥ�� 'c', ���ڶ��� 'a' �޷�ƥ�� 'b'��
 */
fun main() {
    println(isMatch("aa", "a"))
    println(isMatch("aa", "*"))
    println(isMatch("cb", "?a"))
    println(isMatch("aa", "*c"))
    println(isMatch("acdcb", "a*c?b"))
}

private fun isMatch(s: String, p: String): Boolean {
    val sLen = s.length
    val pLen = p.length
    val dp = Array(sLen + 1) { BooleanArray(pLen + 1) }
    dp[0][0] = true

    for (i in 1..pLen) {
        if (p[i - 1] == '*') {
            dp[0][i] = true
        } else {
            break
        }
    }

    for (i in 1..sLen) {
        for (j in 1..pLen) {
            when {
                p[j - 1] == '?' || s[i - 1] == p[j - 1] -> {
                    dp[i][j] = dp[i - 1][j - 1]
                }
                p[j - 1] == '*' -> {
                    /**
                     * 1��dp[i][j - 1] ��ʱ��'*' ��ʾ���ַ������� i ���䣬j - 1 ��Ϊ����'*'����ǰ���ƥ�����
                     * ���� s = "a"�� p = "a*"�� i = 1�� j = 2 ʱ���� dp[i][j - 1] �������Ϊ�� s = "a"��p="a" �Ƿ�ƥ��
                     **/
                    /**
                     * 2��dp[i - 1][j] ��ʱ��'*' ��ʾ����ַ�����������������ǰ�ַ�֮ǰ���ַ��Ƿ�Ҳ�ܱ� '*' ƥ��
                     * ���֮ǰ�ַ��ܣ���ô�ټ������ڵ�һ���ַ���'*' ����ƥ���⼸�������ַ���
                     */
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]
                }
            }
        }
    }

    return dp[sLen][pLen]
}