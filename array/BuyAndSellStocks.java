package array;

public class BuyAndSellStocks {
	public static void main(String[] args) {
		int[] stocks = { 7, 3, 6, 8, 2, 4, 7, 1, 4 };
		sellStocksForMaxProfit(stocks);
	}

	private static void sellStocksForMaxProfit(int[] stocks) {

		int buy = stocks[0], sell = stocks[0], profit = 0;
		for (int i = 1; i < stocks.length; i++) {
			if (buy > stocks[i]) {
				buy = stocks[i];
			} else {
				sell = stocks[i];
				profit = Math.max(profit, sell - buy);
			}
		}
		System.out.println(profit);

	}

}
