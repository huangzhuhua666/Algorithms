package offer

import swap

/**
 * Create by hzh on 2020/4/27.
 * 字符串的排列
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
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
            chars.swap(start, i) // 需要复位
        }
    }
}