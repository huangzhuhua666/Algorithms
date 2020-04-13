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
    println(isMatch("aa", "a"))
    println(isMatch("aa", "a*"))
    println(isMatch("ab", ".*"))
    println(isMatch("aab", "c*a*b"))
    println(isMatch("mississippi", "mis*is*p*."))
    println(isMatch("ab", ".*c"))
}

/**
 * ���ݷ�
 */
private fun isMatch(s: String, p: String): Boolean = if (p.isEmpty()) s.isEmpty()
else {
    // ƥ���һ���ַ���'.'
    val isFirstMatch = s.isNotEmpty() && (s[0] == p[0] || p[0] == '.')

    // ���ģʽ�����Ǻţ���������ڵڶ���λ��p[1]��
    // ��ʱ��
    // 1.ֱ�Ӻ���ģʽ����һ����
    // 2.��ģʽ����ƥ�䵱ǰ�ַ�ʱ��ɾ��ƥ�䴮��һ���ַ�
    // ����������������һ������ʱ�����Ա�ƥ��
    if (p.length >= 2 && p[1] == '*')
        isMatch(s, p.substring(2))
                || (isFirstMatch && isMatch(s.substring(1), p))
    else // ���Ǻţ�ƥ�䴮��ģʽ��ͬʱ���ƣ�ǰ����ģʽ����ƥ�䵱ǰ�ַ�
        isFirstMatch && isMatch(s.substring(1), p.substring(1))
}