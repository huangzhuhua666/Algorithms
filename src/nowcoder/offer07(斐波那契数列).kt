package nowcoder

/**
 * Create by hzh on 2020/3/25.
 * 쳲���������
 *
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
 * n<=39
 */
fun main() {
    println(fibonacci1(39))
    println(fibonacci2(39))
}

/**
 * �ǵݹ�棬��һ�����鱣��ǰ��Ľ��
 */
private fun fibonacci1(n: Int): Int = if (n <= 1) n
else {
    val result = IntArray(n + 1) {
        if (it == 1) 1
        else 0
    }

    for (i in 2..n) {
        result[i] = result[i - 1] + result[i - 2]
    }

    result[n]
}

/**
 * �ݹ��
 */
private fun fibonacci2(n: Int): Int = if (n <= 1) n
else fibonacci2(n - 1) + fibonacci2(n - 2)