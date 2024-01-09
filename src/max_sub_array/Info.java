package max_sub_array;

/**
 * 保存子数组信息
 * @author 45346
 *
 */
public class Info {

	public int max_left;
	public int max_right;
	public int sum;

	public Info(int max_left, int max_right, int sum) {
		this.max_left = max_left;
		this.max_right = max_right;
		this.sum = sum;
	}

}
