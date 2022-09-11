package dynamicPrograaming.recursion;

import java.util.Arrays;

public class EditDistanceString {
	public static void main(String[] args) {
		String s1 = "intention";
		String s2 = "Extention";

		int val = findDistance(s1, s2);
		System.out.println(val);

	}

	private static int findDistance(String s1, String s2) {

		int m = s1.length(), n = s2.length();
		int[][] dist = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++)
			Arrays.fill(dist[i], -1);
		return findDist(s1, s2, m, n, dist);
	}

	private static int findDist(String s1, String s2, int m, int n, int[][] dist) {

		if (m == 0)
			return n;
		if (n == 0)
			return m;

		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			if (dist[m - 1][n - 1] != -1)
				return dist[m][n] = dist[m - 1][n - 1];
			else {
				return dist[m][n] = findDist(s1, s2, m - 1, n - 1, dist);
			}
		}

		int k, l, p;

		if (dist[m][n - 1] != -1)
			k = dist[m][n - 1];
		else {
			k = findDist(s1, s2, m, n - 1, dist);
		}
		if (dist[m - 1][n - 1] != -1)
			l = dist[m - 1][n - 1];
		else {
			l = findDist(s1, s2, m - 1, n - 1, dist);
		}
		if (dist[m - 1][n] != -1)
			p = dist[m - 1][n];
		else {
			p = findDist(s1, s2, m - 1, n, dist);
		}

		return 1 + Math.min(k, Math.min(l, p));

	}

}
