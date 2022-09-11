package TwoPointer;

import java.util.HashMap;

public class TwoSum {
	public static void main(String args[]) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] index = twoSum(nums, 5);
		System.out.println(index[0] +','+ index[1]);

	}

	public static int[] twoSum(int[] nums, int target) {
		int[] index = new int[2];
		HashMap hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.get(target - nums[i]) != null) {
				index[1] = i;
				index[0] = (int) hm.get(target - nums[i]);
				break;
			}
			hm.put(nums[i], i);

		}

		return index;

	}

}


