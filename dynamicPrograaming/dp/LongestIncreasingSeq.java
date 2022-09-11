package dynamicPrograaming.dp;

import java.util.Arrays;

public class LongestIncreasingSeq {
	public static void main(String args[]) {
		int arr[] = { 10, 22, 1,2,3,4,5,6,7,23,34,3,45,23 };
		int n = arr.length;
		int val = longIncSeq_dp(arr, n);
		System.out.println(val);
	}

	private static int longIncSeq_dp(int[] arr, int n) {
		int res[] = new int[arr.length];
		Arrays.fill(res, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j] && res[i] <= res[j]) {
					res[i] = res[j] + 1;
				}

			}
		}

		return Arrays.stream(res).max().getAsInt();
	}
}
