package leetcode

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * Create by hzh on 2024/3/4.
 * ����ˮ
 *
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 *
 * ʾ�� 1��
 * ���룺height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * �����6
 * ���ͣ������������� [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ��
 * ����������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ����
 *
 * ʾ�� 2��
 * ���룺height = [4,2,0,3,2,5]
 * �����9
 */
fun main() {
    println(trap1(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap1(intArrayOf(4, 2, 0, 3, 2, 5)))

    println(trap2(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap2(intArrayOf(4, 2, 0, 3, 2, 5)))

    println(trap3(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap3(intArrayOf(4, 2, 0, 3, 2, 5)))
}

/**
 * ��̬�滮��ÿ�������ܽӵ���ˮ��ȡ���������������ӵĸ߶� min(leftMax, rightMax)
 */
private fun trap1(height: IntArray): Int {
    var result = 0

    val size = height.size

    // �����ұ������ҳ�ÿ�����ӵ�����������ֵ
    var leftMax = 0
    val leftMaxArr = IntArray(size)
    height.forEachIndexed { index, num ->
        leftMax = max(leftMax, num)
        leftMaxArr[index] = leftMax
    }

    // ���ҵ���������ҳ�ÿ�����ӵ��ұ����ӵ����ֵ
    var rightMax = 0
    val rightMaxArr = IntArray(size)
    for (index in size - 1 downTo 0) {
        val num = height[index]
        rightMax = max(rightMax, num)
        rightMaxArr[index] = rightMax
    }

    // ��ǰ�����ܽӵ���ˮ��ȡ���� min(leftMax, rightMax)���������Լ�����ĸ߶�
    height.forEachIndexed { index, num ->
        result += min(leftMaxArr[index], rightMaxArr[index]) - num
    }

    return result
}

/**
 * ����ջ
 */
private fun trap2(height: IntArray): Int {
    var result = 0

    val stack = Stack<Int>()
    height.forEachIndexed { index, num ->
        while (!stack.isEmpty() && num > height[stack.peek()]) {
            val top = stack.pop()
            if (stack.isEmpty()) {
                break
            }

            val distance = index - stack.peek() - 1
            val bound = min(num, height[stack.peek()]) - height[top]
            result += bound * distance
        }

        stack.push(index)
    }

    return result
}

/**
 * ����˫ָ��
 */
private fun trap3(height: IntArray): Int {
    var result = 0
    var left = 0
    var leftMax = 0
    var right = height.size - 1
    var rightMax = 0

    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] > leftMax) {
                leftMax = height[left]
            } else {
                result += leftMax - height[left]
            }

            ++left
        } else {
            if (height[right] > rightMax) {
                rightMax = height[right]
            } else {
                result += rightMax - height[right]
            }

            --right
        }
    }

    return result
}