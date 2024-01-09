/**
 * Create by hzh on 2020/1/14.
 */
private val PILES = intArrayOf(3, 9, 1, 2)

fun main() {
    println("result -> ${stoneGame()}")
}

private fun stoneGame(): Int {
    val dp = Array(PILES.size) { out ->
        Array(PILES.size) { if (it == out) PILES[it] to 0 else 0 to 0 }
    }

    for (l in 1 until PILES.size) {
        for (i in 0 until PILES.size - l) {
            val j = l + i
            val left = PILES[i] + dp[i + 1][j].second
            val right = PILES[j] + dp[i][j - 1].second

            dp[i][j] = if (left > right) left to dp[i + 1][j].first
            else right to dp[i][j - 1].first
        }
    }

    dp.forEach { out ->
        out.forEach { print("(${it.first},${it.second})\t") }
        println()
    }

    return dp[0][PILES.size - 1].let { it.first - it.second }
}