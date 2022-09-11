package dynamicPrograaming.dp;

public class EditDistDP {
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "ebfd";

		int val = findDista(s1, s2, s1.length(), s2.length());
		System.out.println(val);

	}

	private static int findDista(String s1, String s2, int row, int col) {
		int[][] dp = new int[row + 1][col + 1];

		for (int i = 0; i <= row; i++)
			dp[0][i] = i;
		for (int i = 0; i <= col; i++)
			dp[i][0] = i;

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {

				if (s1.charAt(j-1) == s2.charAt(i-1))
					dp[i][j] = dp[i - 1][j - 1];

				else
					dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));

			}
		}

		return dp[row][col];
	}
}
