package max_sub_array;

/**
 * 查找最大子数组
 * @author 45346
 *
 */
public class MaxSubArray {

	/**
	 * 查找最大子数组
	 * @param A 数组
	 * @param low left
	 * @param high high
	 * @return
	 */
	public static Info Find(int[] A, int low, int high) {
		if (low == high) {//只有一个元素
			return new Info(low, high, A[low]);
		} else {
			int mid = (low + high) / 2;

			Info left = Find(A, low, mid);
			Info right = Find(A, mid + 1, high);
			Info cross = Find_Max_Crossing_SubArray(A, low, mid, high);
			
			if (left.sum > right.sum && left.sum > cross.sum) {
				return left;
			} else if (right.sum > left.sum && right.sum > cross.sum) {
				return right;
			} else {
				return cross;
			}
		}
		
	}

	/**
	 * 查找穿过中点的子数组
	 * @param A A
	 * @param low left
	 * @param mid mid
	 * @param high right
	 * @return
	 */
	private static Info Find_Max_Crossing_SubArray(int[] A, int low, int mid, int high) {
		int left_sum = -Integer.MAX_VALUE;
		int right_sum = -Integer.MAX_VALUE;

		int sumLeft = 0;
		int sumRight = 0;

		int max_left = -1;
		int max_right = -1;

		for (int i = mid; i >= low; i--) {
			sumLeft += A[i];
			if (sumLeft > left_sum) {
				left_sum = sumLeft;
				max_left = i;
			}
		}

		for (int i = mid + 1; i <= high; i++) {
			sumRight += A[i];
			if (sumRight > right_sum) {
				right_sum = sumRight;
				max_right = i;
			}
		}

		return new Info(max_left, max_right, left_sum + right_sum);
		
	}

}
