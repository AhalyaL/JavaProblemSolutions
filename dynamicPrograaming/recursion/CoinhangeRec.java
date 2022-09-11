package dynamicPrograaming.recursion;

public class CoinhangeRec {

	public static void main(String[] args) {
		int[] coins = { 1, 3, 5 };
		int change = 4;

		int val = coinChange(coins, change, 0);
		System.out.println(val);

	}

	private static int coinChange1(int[] coins, int change, int ind) {
		if (change == 0)
			return 0;
		if (ind >= coins.length || change < coins[ind])
			return 0;

//		return 1+Math.min(coinChange(coins, change - coins[ind], ind), coinChange(coins, change, ind + 1));

		int temp = Math.min(coinChange(coins, change - coins[ind], ind), coinChange(coins, change, ind + 1));
		if (change > 0 && ind >= coins.length)
			return 0;
		else
			return temp + 1;
	}

	private static int coinChange(int[] coins, int change, int ind) {
		int tempRes = Integer.MAX_VALUE;
		if (change == 0)
			return 0;
		for (int i = 0; i < coins.length; i++) {

			if (change >= coins[i]) {
				int res = coinChange(coins, change - coins[i], ind);

				tempRes = res == Integer.MAX_VALUE ? tempRes : Math.min(res + 1, tempRes);

			}
		}
		return tempRes;

	}
}

