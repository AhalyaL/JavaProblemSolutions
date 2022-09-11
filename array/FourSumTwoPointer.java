package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumTwoPointer {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, -6, -7, 13, 10, -6, 10, 4, 4, 4, 5, -6, -7, 3 };
		List<ArrayList<Integer>> l = findFourSumUsingTwoPointer(nums, 10);
		System.out.println(l);
		System.out.println(l.size());
	}

	private static List<ArrayList<Integer>> findFourSumUsingTwoPointer(int[] nums, int tot) {
		List<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j == i || nums[j] == nums[j - 1])
					continue;
				int p1 = j + 1, p2 = nums.length - 1;

				while (p1 < p2) {
					if (nums[p1] == nums[p1 - 1]) {
						p1++;
						continue;
					}
					if (p2<nums.length-1 && nums[p2] == nums[p2 + 1]) {
						p2--;
						continue;
					}
					int currSum = nums[i] + nums[j] + nums[p1] + nums[p2];
					if (tot == currSum) {
						ArrayList<Integer> l1 = new ArrayList<Integer>();
						l1.add(nums[i]);
						l1.add(nums[j]);
						l1.add(nums[p1]);
						l1.add(nums[p2]);
						l.add(l1);
						p1++;
					} else if (currSum > tot)
						p2--;
					else if (currSum < tot)
						p1++;

				}

			}

		}

		return l;
	}
}
