package dynamicPrograaming.recursion;

import java.util.Arrays;

public class AllSubsetsWithGivenSum {
	public static void main(String[] args) {
		int set[] = { 13, 34, 14, 12, 15, 2, 1 };
		int sum = 15;
		int res[] = new int[set.length];
		System.out.println(isSubsetSum(set, 0, sum, res));
	}

	private static int isSubsetSum(int[] set, int ind, int sum, int[] res) {

		if (ind == set.length)
			return 0;

		if (sum == 0) {
			System.out.println(Arrays.toString(res));
			return 1;
		}

		if (set[ind] > sum)
			return isSubsetSum(set, ind + 1, sum, res);
		else {
			int i = isSubsetSum(set, ind + 1, sum, res);
			res[ind] = set[ind];
			int j = isSubsetSum(set, ind + 1, sum - set[ind], res);
			res[ind] = 0;
			return i + j;
		}

	}
}
