package Miscillanious;

import java.util.HashSet;

public class HappyNumber {
	public static void main(String[] args) {
//		System.out.print(isHappy(11));
		System.out.print(isHappy(4));
		System.out.print(isHappy(19));
		// System.out.print(isHappy(1));
	}

	public static boolean isHappy(int n) {

		while (true) {
			int rem, sum = 0;
			HashSet set = new HashSet();

			while (n > 0) {
				rem = n % 10;
				sum += rem * rem;
				n = n / 10;

			}
			if (sum == 1)
				return true;
			else if (set.contains(sum))
				return false;
			else {
				set.add(sum);
				n = sum;
				continue;
			}
		}

	}
}
