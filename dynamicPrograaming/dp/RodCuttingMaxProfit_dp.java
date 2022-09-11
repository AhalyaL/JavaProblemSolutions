package dynamicPrograaming.dp;

import java.util.Arrays;

public class RodCuttingMaxProfit_dp {
	public static void main(String[] args) {
		int[] len = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] price = { 50, 5, 8, 9, 10, 17, 17, 45 };
		int n = 10;
		int[] dp = new int[n + 1];

		int val = rodCutting(len, price, n, dp);
		System.out.println(val);
	}

	private static int rodCutting(int[] len, int[] price, int n, int[] dp) {
		Arrays.fill(dp, 0);
		for (int lens = 0; lens < len.length; lens++) {
			for (int i = 1; i <= n; i++) {
				if (len[lens] <= i)
					dp[i] = Math.max(dp[i-len[lens]] + price[lens], dp[i]);
			}

		}
		return dp[n];
	}
}
