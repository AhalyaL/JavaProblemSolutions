package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LargestSubArrayMaxSum {
	public static void main(String[] args) {
		int[] a = { 1, -2, 5, 3, 6, -1, -1, -6, -34, 4, 2, 5, 1, 1, 1 };
		largestSubArrayMaxSum(a);
	}

	private static void largestSubArrayMaxSum(int[] a) {
		int max = 0, curr_sum = 0, end = 0, start = 0, s = 0;
		HashMap<List<Integer>, Integer> hm = new HashMap<List<Integer>, Integer>();

		for (int i = 0; i < a.length; i++) {
			curr_sum += a[i];

			if (max <= curr_sum) {
				max = curr_sum;
				start = s;
				end = i;
				List l = new ArrayList();
				l.add(start);
				l.add(end);
				hm.put(l, max);
			}

			if (curr_sum < 0) {
				s = i + 1;
				curr_sum = 0;
			}

		}

		System.out.println(start + "," + end +","+hm);
	}
}
