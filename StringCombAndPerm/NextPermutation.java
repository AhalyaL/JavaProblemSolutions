package StringCombAndPerm;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		arr = findNextPermutation(arr);

		System.out.println(Arrays.toString(arr));
	}

	private static int[] findNextPermutation(int[] arr) {

		int len = arr.length - 1;
		int suc = arr.length - 1;
		int pivot = 0, successor = 0;

		while (len >= 0) {

			if (arr[len] > arr[len - 1]) {
				pivot = arr[len - 1];
				break;
			}
			len--;

		}
		if (len == 0) {
			Arrays.sort(arr);
			return arr;
		}

		while (suc > 0) {

			if (arr[suc] > pivot) {
				successor = arr[suc];
				break;
			}
			suc--;
		}

         int temp=arr[suc];
         arr[suc]=pivot;
         arr[len-1]=temp;

		Arrays.sort(arr, len, suc);
		return arr;
	}

}
