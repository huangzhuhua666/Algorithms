package offer

/**
 * Create by hzh on 2020/5/18.
 * 第一个只出现一次的字符
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
fun main() {
    println(firstNoRepeatingChar("abcdadbc"))
}

private fun firstNoRepeatingChar(str: String?): Int = if (str == null || str.trim().isEmpty()) -1
else {
    val count = mutableMapOf<Char, Int>()

    str.forEach { count[it] = if (count.containsKey(it)) count[it]!! + 1 else 1 }

    str.forEachIndexed { index, c -> if (count[c] == 1) return index }

    -1
}