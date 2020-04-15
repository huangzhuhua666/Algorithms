package offer

/**
 * Create by hzh on 2020/3/20.
 * ��ת�������С����
 *
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */
fun main() {
    println(minNumberInRotateArray(intArrayOf(5, 1, 2, 3, 4)))
    println(minNumberInRotateArray(intArrayOf(1, 0, 1, 1, 1)))
}

private fun minNumberInRotateArray(array: IntArray): Int {
    if (array.isEmpty()) return 0

    var left = 0
    var right = array.size - 1
    var mid = 0

    while (array[left] >= array[right]) {
        if (right - left == 1) {
            mid = right
            break
        }

        mid = (left + right) / 2

        // ������ͬԪ��
        if (array[left] == array[right] && array[mid] == array[left]) return orderFind(array, left, right)

        if (array[mid] >= array[left]) left = mid // �м�Ԫ��λ��ǰ��ĵ������飬������СԪ��Ӧ���������м�ĺ���
        else right = mid // �м�Ԫ��λ�ں���ĵ������飬������СԪ��Ӧ���������м��ǰ��
    }

    return array[mid]
}

private fun orderFind(array: IntArray, left: Int, right: Int): Int {
    var result = array[left]
    for (i in left + 1 until right) {
        if (array[i] < result) {
            result = array[i]
            break
        }
    }
    return result
}