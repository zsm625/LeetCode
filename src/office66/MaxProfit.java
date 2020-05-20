package office66;

/**
 * 投股票的最佳时期
 * 
 * @author ZSM
 *
 * @time 2020年3月9日下午5:19:19
 */
public class MaxProfit {
	
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length==0) {
			return 0;
		}
		int p1=prices[0];
		int max = 0;
		for(int i=1;i<prices.length;i++) {
			if(p1>prices[i]) {
				p1= prices[i];
			}else if(prices[i]-p1>max) {
				max = prices[i]-p1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaxProfit profit = new MaxProfit();
		int[] prices = {7,3,1,4,6,5};
		int i = profit.maxProfit(prices);
		System.out.println(i);
	}
}
