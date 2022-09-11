package array;

public class MinInSortedRotatedArray {
	public static void main(String[] args) {

		int[] nums = { 4, 5, 6, 7, 0, 1, 2, 3 };
		System.out.println(MinInSortedRotatedArray(nums));
	}

	private static int MinInSortedRotatedArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int i = 0, j = nums.length - 1, mid = 0;
		while (i < j) {
			mid = i + (j - i) / 2;
			if (nums[mid] > nums[j])
				i = mid + 1;
			else
				j = mid;

		}

		return i;
	}
}
