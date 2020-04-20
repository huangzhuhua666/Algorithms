/**
 * Create by hzh on 2020/1/13.
 * �ַ���ƥ��
 *
 * ���������ַ���������ַ���A�Ƿ�����ַ���B�����������������һ�γ��ֵ�λ��
 */
private const val A = "abaabaabbabaaabaabbabaab"
private const val B = "abaabbabaab"

fun main() {
    println("result -> ${br1()}")
    println("result -> ${br2()}")
    println("result -> ${kmp()}")
}

/**
 * �����ⷨ��д��һ
 */
private fun br1(): Int {
    var i = 0
    var j = 0

    while (i < A.length && j < B.length) {
        if (A[i] == B[j]) {
            ++i
            ++j

            if (j == B.length) return i - j
        } else {
            i = i - j + 1
            j = 0
        }
    }
    return -1
}

/**
 * �����ⷨ��д����
 */
private fun br2(): Int {
    for (i in 0..A.length - B.length) {
        var j = 0

        while (j < B.length) {
            if (A[i + j] != B[j]) break

            ++j
        }
        if (j == B.length) return i
    }

    return -1
}

/**
 * KMP�㷨
 */
private fun kmp(): Int {
    // �������飬next[i]��ʾ����Bǰi + 1λ�ַ��������ͬ��ǰ׺�ͺ�׺�ĳ���
    // ��ƥ���ַ���ʱ
    val next = IntArray(B.length) { -1 }

    // �������Bǰi + 1λ�ַ��������ͬ��ǰ׺�ͺ�׺�ĳ���
    // �ɸ���ǰһ�����������
    for (i in 1 until B.length) {
        var j = next[i - 1]

        while (B[j + 1] != B[i] && j >= 0) j = next[j]

        next[i] = if (B[j + 1] == B[i]) j + 1 else -1
    }

    var i = 0
    var j = 0
    while (i < A.length) {
        if (A[i] == B[j]) {
            ++i
            ++j

            if (j == B.length) return i - j
        } else {
            if (j == 0) ++i // B�ַ�����һ���ַ��ͺ�A�ַ�����ǰ�ַ���ƥ��ʱ��A�ַ���ֱ��������һλ
            // abaab aabbabaaabaabbabaab i = 5
            // abaab babaab              j = 5
            // ���ϣ���5λ��ʼ�Ų�ƥ�䣬��
            // abaab aabbabaaabaabbabaab i = 5
            //    ab aabbabaab           j = 2
            // B�ַ�������next[5 - 1] + 1 = 2λ��A�ַ����±겻�伴��
            else j = next[j - 1] + 1
        }
    }

    return -1
}