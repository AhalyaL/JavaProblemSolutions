package dynamicPrograaming.recursion;

public class MCM_Rec {
	public static void main(String[] args) {
		int[] dim = { 40, 20, 30, 10, 30 };

		int val = mcm(dim, 1, dim.length - 1);

		System.out.println(val);
	}

	private static int mcm(int[] dim, int s, int e) {

		int res = Integer.MAX_VALUE;

		if (s == e)
			return 0;
		for (int i = s; i < e; i++) {
			int temp_res = mcm(dim, s, i) + mcm(dim, i + 1, e) + dim[s - 1] * dim[i] * dim[e];
			res = Math.min(res, temp_res);
		}

		return res;
	}
}
