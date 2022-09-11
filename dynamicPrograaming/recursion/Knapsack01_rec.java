package dynamicPrograaming.recursion;

public class Knapsack01_rec {
	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 , 1000 };
		int wt[] = new int[] { 10, 20, 30 ,60};
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, 0));
	}

	private static int knapSack(int w, int[] wt, int[] val, int ind) {

		if (ind == wt.length || w <= 0)
			return 0;

		if (wt[ind] > w)
			return knapSack(w, wt, val, ind + 1);
		else
			return Math.max(val[ind] + knapSack(w - wt[ind], wt, val, ind + 1), knapSack(w, wt, val, ind + 1));

	}
}
