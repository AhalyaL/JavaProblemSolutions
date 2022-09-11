package dynamicPrograaming.dp;

public class CoinChange {
	public static void main(String[] args) {
		int[] coins = { 3, 5 };
		int change = 7;

		int val = coinChange(coins, change);
		System.out.println(val);

	}

	private static int coinChange(int[] coins, int change) {

		int[][] dp = new int[coins.length + 1][change + 1];

		for (int i = 0; i <= change; i++)
			dp[0][i] = Integer.MAX_VALUE;
		for (int i = 0; i <= coins.length; i++)
			dp[i][0] = 0;

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= change; j++) {

				if (coins[i - 1] > j)
					dp[i][j] = dp[i - 1][j];

				else {
					int temp = Math.min(dp[i][j - coins[i - 1]], dp[i - 1][j]);
					dp[i][j] = temp == Integer.MAX_VALUE ? Integer.MAX_VALUE : temp + 1;
				}
			}
		}
		for (int i = 0; i <= coins.length; i++) {
			for (int j = 0; j <= change; j++) {
				System.out.print(dp[i][j] + "      ");

			}
			System.out.println("\n");
		}

		return dp[coins.length][change];
	}
}
