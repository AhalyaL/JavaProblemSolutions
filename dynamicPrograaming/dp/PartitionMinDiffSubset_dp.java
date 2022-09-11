package dynamicPrograaming.dp;

import java.util.Arrays;

public class PartitionMinDiffSubset_dp {
	public static void main(String[] args) {
		int set[] = { 3, 14, 5, 2 };

		System.out.println(partitionMinDiff(set));
	}

	private static int partitionMinDiff(int[] set) {

		int sum = Arrays.stream(set).sum();

		boolean dp[][] = new boolean[set.length + 1][sum + 1];

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
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];

			}
		}

		int k = sum / 2;
		for (int i = k; i > 0; i--) {
			if (dp[set.length][i]) {
				return sum - 2 * i;
			}

		}
		return k;

	}
}
