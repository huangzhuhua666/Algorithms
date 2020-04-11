package nowcoder

/**
 * Create by hzh on 2020/3/17.
 * ��ά�����еĲ���
 *
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */
fun main() {
    val array = arrayOf(intArrayOf(1, 5, 9, 13),
            intArrayOf(2, 6, 10, 14),
            intArrayOf(3, 7, 11, 15),
            intArrayOf(4, 8, 12, 16))

    println(find(7, array))
}

private fun find(target: Int, array: Array<IntArray>): Boolean {
    var i = 0
    var j = array[0].size - 1

    // ���������Ͻǿ�ʼ����
    while (i < array.size && j > 0) {
        if (array[i][j] == target) return true // ��ǰֵ����target������true

        if (array[i][j] > target) --j // ��ǰֵ��target�������������С��Χ
        else ++i // ��ǰֵ��targetС��������������С��Χ
    }

    return false // �Ҳ���target
}