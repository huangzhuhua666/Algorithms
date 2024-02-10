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

        // dp[��ǰ״̬][�ַ�] = [��һ��״̬]
        dp = Array(patLen) { IntArray(CHAR_LEN) }
        // ��ʼ״̬��dp[0][ģʽ����һ���ַ�] = 1����ʾ��ǰ״̬Ϊ 0 ʱ������ģʽ����һ���ַ���״̬ת�Ƶ� 1
        dp[0][pat.first().toInt()] = 1

        // Ӱ��״̬��ʼΪ 0
        var shadow = 0
        for (j in 1 until patLen) {
            val currChar = pat[j].toInt()

            for (c in 0 until CHAR_LEN) {
                dp[j][c] = if (currChar == c) {
                    // ƥ�����ˣ�dp[j][�ַ�]ת�Ƶ���һ��״̬
                    j + 1
                } else {
                    // ƥ�䲻�ϣ�dp[j][�ַ�]״̬����
                    dp[shadow][c]
                }
            }

            // ����Ӱ��״̬
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