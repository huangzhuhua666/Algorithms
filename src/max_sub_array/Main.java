package max_sub_array;

public class Main {

	public static void main(String[] args) {
		int[] A = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		
		Info max_sub_array = MaxSubArray.Find(A, 0, A.length - 1);
		
		int left = max_sub_array.max_left;
		int right = max_sub_array.max_right;
		int sum = max_sub_array.sum;
		
		System.out.println("数组A的一个最大子数组是：A[" + left + "] -> A[" + right + "] , 它的和是：" + sum);
		
	}

}
