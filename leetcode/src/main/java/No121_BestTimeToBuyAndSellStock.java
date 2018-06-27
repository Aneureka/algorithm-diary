/**
 * Created by Hiki on 9/23/2017.
 */
public class No121_BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int length = prices.length;
		if (length < 2) {
			return 0;
		}

		// save the minimum stock price and max diff price
		int min = prices[0];
		int diff = 0;

		for (int i = 1; i < length; i++) {
			int curDiff = prices[i] - min;
			if (curDiff > diff) {
				diff = curDiff;
			}
			if (prices[i] < min) {
				min = prices[i];
			}

		}

		return diff;
	}

	public int maxProfit2(int[] prices) {
        return 0;
	}

	public static void main(String[] args) {
		No121_BestTimeToBuyAndSellStock b = new No121_BestTimeToBuyAndSellStock();
		System.out.println(b.maxProfit(new int[]{2,1,2,0,1}));
	}
}
