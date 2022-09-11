package dynamicPrograaming.dp;

public class AllSubsetsWithGivenSum {
	public static void main(String[] args) {
		int set[] = { 3,4, 2, 1 };
		int sum = 5;
		int res[] = new int[set.length];
		boolean dp[][] = new boolean[set.length + 1][sum + 1];
		System.out.println(isSubsetSum(set, 0, sum, dp));
	}

	private static boolean isSubsetSum(int[] set, int ind, int sum, boolean[][] dp) {

		for (int i = 0; i <= set.length; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0 && j == 0)
					dp[i][j] = true;
				else if (i == 0)
					dp[i][j] = false;
				else if (j == 0)
					dp[i][j] = true;
				else if (set[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j - set[i - 1]] || dp[i - 1][j];

			}
		}

		return dp[set.length][sum];
	}
}
