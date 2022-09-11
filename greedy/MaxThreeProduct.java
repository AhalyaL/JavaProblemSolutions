package greedy;

import java.util.Arrays;

public class MaxThreeProduct {
	public static void main(String[] args) {
		int[] nums = { -100,-98,-1,2,3,4 };
		int c = maximumProduct(nums);
		System.out.println(c);
	}

	public static int maximumProduct(int[] nums) {

		if (nums == null || nums.length < 3)
			return 0;

		Arrays.sort(nums);
		return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
				nums[nums.length - 1] * nums[0] * nums[1]);

	}
}
