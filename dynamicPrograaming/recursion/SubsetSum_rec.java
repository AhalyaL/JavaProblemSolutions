package dynamicPrograaming.recursion;

public class SubsetSum_rec {
	public static void main(String[] args) {
		int set[] = { 13, 34, 14, 12, 15, 2 };
		int sum = 15;
		System.out.println(isSubsetSum(set, 0, sum));
	}

	private static boolean isSubsetSum(int[] set, int ind, int sum) {

		if (ind == set.length)
			return false;

		if (sum == 0)
			return true;

		if (set[ind] > sum)
			return isSubsetSum(set, ind + 1, sum);
		else
			return isSubsetSum(set, ind + 1, sum) || isSubsetSum(set, ind + 1, sum - set[ind]);

	}
}
