package leetcode

/**
 * Create by hzh on 2020/4/13.
 * ������ʽƥ��
 *
 * ����һ���ַ���s��һ���ַ�����p��������ʵ��һ��֧��'.'��'*'��������ʽƥ�䡣
 * '.'ƥ�����ⵥ���ַ�
 * '*'ƥ���������ǰ�����һ��Ԫ��
 */
fun main() {
    println(isMatch1("aa", "a"))
    println(isMatch1("aa", "a*"))
    println(isMatch1("ab", ".*"))
    println(isMatch1("aab", "c*a*b"))
    println(isMatch1("mississippi", "mis*is*p*."))
    println(isMatch1("ab", ".*c"))
    println("---split line ---")
    println(isMatch2("aa", "a"))
    println(isMatch2("aa", "a*"))
    println(isMatch2("ab", ".*"))
    println(isMatch2("aab", "c*a*b"))
    println(isMatch2("mississippi", "mis*is*p*."))
    println(isMatch2("ab", ".*c"))
}

/**
 * ���ݷ�
 */
private fun isMatch1(s: String, p: String): Boolean = if (p.isEmpty()) s.isEmpty()
else {
    // ƥ���һ���ַ���'.'
    val isFirstMatch = s.isNotEmpty() && (s[0] == p[0] || p[0] == '.')

    // ���ģʽ�����Ǻţ���������ڵڶ���λ��p[1]��
    // ��ʱ��
    // 1.ֱ�Ӻ���ģʽ����һ����
    // 2.��ģʽ����ƥ�䵱ǰ�ַ�ʱ��ɾ��ƥ�䴮��һ���ַ�
    // ����������������һ������ʱ�����Ա�ƥ��
    if (p.length >= 2 && p[1] == '*')
        isMatch1(s, p.substring(2))
                || (isFirstMatch && isMatch1(s.substring(1), p))
    else // ���Ǻţ�ƥ�䴮��ģʽ��ͬʱ���ƣ�ǰ����ģʽ����ƥ�䵱ǰ�ַ�
        isFirstMatch && isMatch1(s.substring(1), p.substring(1))
}

private fun isMatch2(s: String, p: String): Boolean {
    val sLen = s.length
    val pLen = p.length
    val dp = Array(sLen + 1) { BooleanArray(pLen + 1) }
    dp[0][0] = true

    for (i in 0..sLen) {
        for (j in 1..pLen) {
            if (p[j - 1] == '*') {
                // ����Ϊ 'a*'���� 'a*' ���������� dp[i][j - 2] ������
                dp[i][j] = dp[i][j - 2]
                // �����ǰ�ַ��� '*' ��ǰһ���ַ�ƥ���ϣ���̶� j��i - 1����� dp[i - 1][j] ������
                if (matches(s, p, i, j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j]
                }
            } else {
                if (matches(s, p, i, j)) {
                    // �ַ�ƥ�䣬�Һ��治Ϊ '*'������ dp[i - 1][j - 1] ������
                    dp[i][j] = dp[i - 1][j - 1]
                }
            }
        }
    }

    return dp[sLen][pLen]
}

/**
 * �жϵ����ַ��Ƿ���ȣ������Ƿ�Ϊ'.'��i = 0 ʱ����ʾ s Ϊ���ַ���
 */
private fun matches(s: String, p: String, i: Int, j: Int): Boolean {
    if (i == 0) {
        return false
    }

    return s[i - 1] == p[j - 1] || p[j - 1] == '.'
}