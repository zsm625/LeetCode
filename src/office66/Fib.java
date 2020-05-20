package office66;

/**
 * 斐波那契数列
 * @author ZSM
 *
 * @time 2020年3月5日下午4:40:06
 */
public class Fib {

	/**
	 * 可以用递归直接写，但是性能不高，总是在重复计算已经得出的数，当n越来越大时，会栈溢出
	 * 因此可以用一个数组将之前计算好的值保存，计算时先在数组中找
	 * 缺点是需要额外的数组空间
	 *但是当n超过24时就会导致超出时间
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int  fib(int n) {
		int[] dp = new int[n+1];
		dp[1] = dp[2] = 1;
		for(int i=3;i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	/**
	 * 采用动态规划，最优方案
	 * 
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int fib2(int n) {
		int a= 0,b = 1,sum;
		for(int i=0;i<n;i++) {
			sum=(a+b)%1000000007;
			a=b;
			b = sum;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Fib fib = new Fib();
		int i = fib.fib(43);
		System.out.println(i);
	}
}
