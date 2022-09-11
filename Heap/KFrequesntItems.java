package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class KFrequesntItems {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] ans = topKFrequent(nums, k);
		System.out.println(Arrays.toString(ans));

	}

	public static int[] topKFrequent(int[] nums, int k) {

		int[] ans = new int[k];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

		}
	
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
				(a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey())
						: Integer.compare(b.getValue(), a.getValue()));

		pq.addAll(hm.entrySet());

		for (int i = 0; i < k; i++)
			ans[i] = pq.poll().getKey();

		return ans;

	}

}
