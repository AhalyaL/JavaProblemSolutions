package slidingWindow;

public class MinSizeSubArraySum {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		System.out.println(maxSubArray(11, a));
	}

	public static int maxSubArray(int target, int[] nums) {

		int i = 0, j = 1, sum = 0, count = 0;
		while (i < nums.length) {

			if (sum < target && j<=nums.length) {
				sum += nums[j - 1];
				j++;
			} else if (sum == target) {
				sum -= nums[i];
				if (count == 0)
					count = j - i - 1;
				else
					count = Math.min(count, j - i - 1);
				// sum += nums[j];
				i++;
			} else {
				sum = sum - nums[i];
				i++;
			}
		}
		return count;
	}

}
