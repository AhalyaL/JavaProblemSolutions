package dynamicPrograaming.recursion;

import java.util.Arrays;

public class RodCuttingMaxProfit_rec {
	public static void main(String[] args) {
		int[] len = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] price = { 5, 5, 8, 9, 10, 17, 17, 45 };

		int n = 10;
		int val = rodCutting(len, 0, price, n);
		System.out.println(val);
	}

	private static int rodCutting(int[] len, int index, int[] price, int remLen) {

		if(index >=len.length||remLen<len[index]) {
			return 0;
		}
		
		int uncut = rodCutting( len,index+1, price,  remLen);
		
		int cut = price[index]+rodCutting( len,index, price,  remLen-len[index]);
		
		
		return Math.max(uncut, cut);
	}
}
