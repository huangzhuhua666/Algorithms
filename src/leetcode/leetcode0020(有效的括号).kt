package leetcode

import java.util.*

/**
 * Create by hzh on 2024/2/1.
 * ��Ч������
 *
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ��� s ���ж��ַ����Ƿ���Ч��
 * ��Ч�ַ��������㣺
 * 1�������ű�������ͬ���͵������űպϡ�
 * 2�������ű�������ȷ��˳��պϡ�
 * 3��ÿ�������Ŷ���һ����Ӧ����ͬ���͵������š�
 *
 * ʾ�� 1��
 * ���룺s = "()"
 * �����true
 *
 * ʾ�� 2��
 * ���룺s = "()[]{}"
 * �����true
 *
 * ʾ�� 3��
 * ���룺s = "(]"
 * �����false
 */
fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
    println(isValid("]"))
}

private fun isValid(s: String): Boolean {
    val stack = Stack<Char>()

    s.forEach {
        if (it in listOf('(', '[', '{')) {
            stack.push(it)
        } else {
            if (stack.isEmpty()) {
                return false
            }

            when (it) {
                ')' -> {
                    if (stack.pop() !=  '(') {
                        return false
                    }
                }
                ']' -> {
                    if (stack.pop() != '[') {
                        return false
                    }
                }
                '}' -> {
                    if (stack.pop() != '{') {
                        return false
                    }
                }
            }
        }
    }

    return stack.isEmpty()
}