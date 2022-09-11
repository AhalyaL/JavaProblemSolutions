package array;

public class SearchInRotatedArrays {
	public static void main(String[] args) {

		int[] nums = { 1 };
		int target = 1;
		System.out.println(search(nums, target));
	}

	public static int search(int[] nums, int target) {
		 if (nums == null || nums.length == 0) {
	            return -1;
	        }
		int i = 0;
		int pivot = 0;
		int j = nums.length - 1;
		while (i < j) {

			int mid = i + (j - i) / 2;
			if (nums[mid] > nums[j]) {
				i = mid + 1;
			} else {
				j = mid;
			}

		}
		pivot = i;
		i = 0;
		j = nums.length - 1;

		if (nums[j] >= target && target >= nums[pivot])
			i = pivot-1;

		else
			j = pivot;

		while (i < j) {

			int mid = i + (j - i) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}

		}

		return -1;

	}

}
