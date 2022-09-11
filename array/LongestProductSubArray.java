package array;

import java.util.ArrayList;
import java.util.List;

public class LongestProductSubArray {
	public static void main(String[] args) {
		int[] a = {0,-1 };

		maxProduct(a);
	}

	private static void maxProduct(int[] a) {

		int pos = 0, neg = 0, max = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				pos++;

			} else if (a[i] < 0) {
				neg++;
				if (neg == 1) {
					max =Math.max(max, pos);
				} else if (neg == 2) {
					pos += neg;
					neg = 0;
				}
			} else if (a[i] == 0) {
				//if (neg == 1)
					//max=Math.max(max, 1);
			//	else
					max=Math.max(max, pos);
					max=Math.max(max, 1);
				pos = 0;
				neg = 0;

			}

		}
		max=Math.max(max, pos);
		System.out.println(max);
	}
}
