package leetcode

/**
 * Create by hzh on 2020/4/14.
 * 罗马数字转整数
 */
fun main() {
    println(romanToInt("III"))
    println(romanToInt("IV"))
    println(romanToInt("IX"))
    println(romanToInt("LVIII"))
    println(romanToInt("MCMXCIV"))
}

private fun romanToInt(s: String): Int = when (s.isEmpty()) {
    true -> 0
    else -> {
        val nums = IntArray(s.length)

        s.forEachIndexed { index, c ->
            nums[index] = when (c) {
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> 0
            }
        }

        var sum = 0

        for (i in 0 until nums.size - 1) {
            sum += if (nums[i] < nums[i + 1]) -nums[i] else nums[i]
        }

        sum + nums[nums.size - 1]
    }
}