package array;

import java.util.HashSet;
import java.util.Arrays;

public class LongestConsequtiveSubSequence {
	public static void main(String[] args) {
		int[] nums = {1,2,0,1};
		int n = longestConsecutive(nums);
		System.out.println(n);
	}

	public static int longestConsecutive(int[] nums) {

   if(nums==null|| nums.length==0)return 0;
		Arrays.sort(nums);
		int max = 0, count = 0, prev = nums[0];
		for (int i : nums) {
               if(prev==i) continue;
			if (prev + 1 != i) {
				max = Math.max(max, count);
				count = 0;
               
			}
			prev=i;
			count++;

		}
		max = Math.max(max, count);
		return max;

	}
}
