package array;

import java.util.Arrays;

public class ArrayProductExceptSelf {

	public static void main(String[] args) {
		int[] nums = { -1,1,0,-3,3 };
		int[] result = productExceptSelf(nums);
		System.out.println(Arrays.toString(result));
	}

	private static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		int temp = 1;
		int product = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] = product * temp;
			temp = nums[i];
			product = result[i];

		}
		temp = 1;
		product = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			result[i] = result[i] * product;
			product = nums[i] * product;

		}

		return result;
	}

}
