/**
 * Create by hzh on 2024/2/9.
 *
 * KMP:[https://zhuanlan.zhihu.com/p/83334559]
 */
class KMP(private val pat: String) {

    companion object {

        private const val CHAR_LEN = 256
    }

    private val dp: Array<IntArray>

    init {
        val patLen = pat.length

        // dp[当前状态][字符] = [下一个状态]
        dp = Array(patLen) { IntArray(CHAR_LEN) }
        // 初始状态，dp[0][模式串第一个字符] = 1，表示当前状态为 0 时，遇到模式串第一个字符，状态转移到 1
        dp[0][pat.first().toInt()] = 1

        // 影子状态初始为 0
        var shadow = 0
        for (j in 1 until patLen) {
            val currChar = pat[j].toInt()

            for (c in 0 until CHAR_LEN) {
                dp[j][c] = if (currChar == c) {
                    // 匹配上了，dp[j][字符]转移到下一个状态
                    j + 1
                } else {
                    // 匹配不上，dp[j][字符]状态回退
                    dp[shadow][c]
                }
            }

            // 更新影子状态
            shadow = dp[shadow][currChar]
        }
    }

    fun search(txt: String): Int {
        if (txt.isEmpty() || pat.isEmpty()) {
            return -1
        }

        val patLen = pat.length
        val txtLen = txt.length
        if (txtLen < patLen) {
            return -1
        }

        var currState = 0
        for (i in 0 until txtLen) {
            currState = dp[currState][txt[i].toInt()]

            if (currState == patLen) {
                return i - patLen + 1
            }
        }

        return -1
    }
}