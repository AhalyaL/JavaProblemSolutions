package BINARY;

import java.util.Arrays;

public class aDDoNE {
	public static void main(String[] args) {
		int[] digits = { 9, 9, 9 };

		int[] n = plusOne(digits);
		System.out.println(Arrays.toString(n));
	}

	public static int[] plusOne(int[] digits) {
		int rem = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (rem == 0)
				break;
			if (digits[i] + rem == 10) {
				digits[i] = 0;
				rem = 1;
			} else {
				digits[i] = digits[i] + rem;
				rem = 0;
			}
		}
		if (rem == 1) {
			int[] n = new int[digits.length + 1];
			n[0] = 1;
			int l = 1;
			for (int k : digits) {
				n[l] = k;
				l++;
			}
			return n;
		}

		return digits;

	}
}
