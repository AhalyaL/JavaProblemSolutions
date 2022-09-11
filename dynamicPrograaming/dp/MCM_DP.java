package dynamicPrograaming.dp;

import java.util.Arrays;

public class MCM_DP {
	public static void main(String[] args) {
		int[] dim = { 40, 20, 30, 10, 30 };
		int res[][] = new int[100][100];

		for (int[] row : res)
			Arrays.fill(row, -1);
		int val = mcm(dim, 1, dim.length - 1, res);
		System.out.println(val);
	}

	private static int mcm(int[] dim, int s, int e, int[][] res) {

		if (s == e)
			return 0;
		if (res[s][e] != -1)
			return res[s][e];

		res[s][e] = Integer.MAX_VALUE;

		for (int i = s; i < e; i++) {
			int temp_res = mcm(dim, s, i, res) + mcm(dim, i + 1, e, res) + dim[s - 1] * dim[i] * dim[e];
			res[s][e] = Math.min(res[s][e], temp_res);
		}

		return res[s][e];
	}
}
