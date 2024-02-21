package leetcode

/**
 * Create by hzh on 2024/2/20.
 * �������е��ʵ��Ӵ�
 *
 * ����һ���ַ��� s ��һ���ַ������� words�� words �������ַ��� ������ͬ��
 * s �е� �����Ӵ� ��ָһ������  words �������ַ���������˳�����������������Ӵ���
 * ���磬��� words = ["ab","cd","ef"]��
 * ��ô "abcdef"�� "abefcd"��"cdabef"�� "cdefab"��"efabcd"�� �� "efcdab" ���Ǵ����Ӵ���
 * "acdbef" ���Ǵ����Ӵ�����Ϊ�������κ� words ���е����ӡ�
 * �������д����Ӵ��� s �еĿ�ʼ������������� ����˳�� ���ش𰸡�
 *
 * ʾ�� 1��
 * ���룺s = "barfoothefoobarman", words = ["foo","bar"]
 * �����[0,9]
 * ���ͣ���Ϊ words.length == 2 ͬʱ words[i].length == 3�����ӵ����ַ����ĳ��ȱ���Ϊ 6��
 * �Ӵ� "barfoo" ��ʼλ���� 0������ words ���� ["bar","foo"] ˳�����е����ӡ�
 * �Ӵ� "foobar" ��ʼλ���� 9������ words ���� ["foo","bar"] ˳�����е����ӡ�
 * ���˳���޹ؽ�Ҫ������ [9,0] Ҳ�ǿ��Եġ�
 *
 * ʾ�� 2��
 * ���룺s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * �����[]
 * ���ͣ���Ϊ words.length == 4 ���� words[i].length == 4�����Դ����Ӵ��ĳ��ȱ���Ϊ 16��
 * s ��û���Ӵ�����Ϊ 16 ���ҵ��� words ���κ�˳�����е����ӡ�
 * �������Ƿ���һ�������顣
 *
 * ʾ�� 3��
 * ���룺s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * �����[6,9,12]
 * ���ͣ���Ϊ words.length == 3 ���� words[i].length == 3�����Դ����Ӵ��ĳ��ȱ���Ϊ 9��
 * �Ӵ� "foobarthe" ��ʼλ���� 6������ words ���� ["foo","bar","the"] ˳�����е����ӡ�
 * �Ӵ� "barthefoo" ��ʼλ���� 9������ words ���� ["bar","the","foo"] ˳�����е����ӡ�
 * �Ӵ� "thefoobar" ��ʼλ���� 12������ words ���� ["the","foo","bar"] ˳�����е����ӡ�
 */
fun main() {
    println(findSubstring("barfoothefoobarman", arrayOf("foo", "bar")))
    println(findSubstring("barfo", arrayOf("foo", "bar")))
    println(findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word")))
    println(findSubstring("barfoofoobarthefoobarman", arrayOf("bar", "foo", "the")))
}

private fun findSubstring(s: String, words: Array<String>): List<Int> {
    if (s.isEmpty() || words.isEmpty()) {
        return emptyList()
    }

    val wordLen = words[0].length
    val wordCount = words.size
    val wordsTotalLen = wordLen * wordCount
    if (s.length < wordsTotalLen) {
        return emptyList()
    }

    val result = mutableListOf<Int>()

    val wordMap = mutableMapOf<String, Int>()
    // ͳ��ÿ�� word ���ֵ�Ƶ��
    words.forEach {
        wordMap[it] = wordMap.getOrDefault(it, 0) + 1
    }

    val countMap = mutableMapOf<String, Int>()
    var isMatch: Boolean
    for (i in 0..s.length - wordsTotalLen) {
        isMatch = true
        countMap.clear()

        for (j in 0 until wordCount) {
            // �� word ���Ƚ��Ӵ�
            val startIndex = i + wordLen * j
            val subStr = s.substring(startIndex, startIndex + wordLen)

            // words �в���������Ӵ�
            if (!wordMap.containsKey(subStr)) {
                isMatch = false
                break
            }

            // �Ӵ����� + 1
            countMap[subStr] = countMap.getOrDefault(subStr, 0) + 1
            // ��� countMap[subStr] > wordMap[subStr]����������Ӵ������в�����Ҫ��
            if ((countMap[subStr] ?: 0) > (wordMap[subStr] ?: 0)) {
                isMatch = false
                break
            }
        }

        if (isMatch) {
            result.add(i)
        }
    }

    return result
}