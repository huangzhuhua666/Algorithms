package offer

/**
 * Create by hzh on 2020/3/25.
 * ���θ���
 *
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * ����n=3ʱ��2*3�ľ��ο���3�ָ��Ƿ�����
 */
fun main() {
    println(rectCover1(4))
    println(rectCover2(4))
}

private fun rectCover1(target: Int): Int = if (target <= 3) target
else {
    val result = IntArray(target + 1) {
        if (it <= 3) it
        else 0
    }

    for (i in 4..target) {
        result[i] = result[i - 1] + result[i - 2]
    }

    result[target]
}

private fun rectCover2(target: Int): Int = if (target <= 3) target
else rectCover2(target - 1) + rectCover2(target - 2)