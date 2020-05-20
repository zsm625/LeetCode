package office66;

/**
 * 丑数
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 * @author ZSM
 *
 * @time 2020年3月18日上午10:52:03
 */
public class NthUglyNumber {

	/**
	 * 动态规划
	 * 时分巧妙的动态规划
	 * 1、先将前面求得的丑数记录下来，后面的丑数就是前面的丑数*2，*3，*5
	 * 2、问题来了，该如何确定已知前面k-1个丑数，我怎么确定第k个丑数呢？
	 * 3、采用三个指针的方法，p2、p3、p5
	 * 4、p2指向的数字下一次永远是*2，p3永远是*3、p5永远是*5
	 * 5、从这三种数字中选取最小的数字，作为第k个丑数
	 * 6、如果第k个丑数==2*p2，也就是前面的0-p2个丑数*2不可能产生比第k个丑数更大的
	 * 
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
		if(n<=0) {
			return 0;
		}
		int[] dp = new int[n];
		dp[0] = 1;
		int p2=0,p3=0,p5=0;
		for(int i=1;i<n;i++) {
			dp[i] = Math.min(dp[p2]*2, Math.min(dp[p3]*3,dp[p5]*5));
			
			if(dp[i]==dp[p2]*2) p2++;
			if(dp[i]==dp[p3]*3) p3++;
			if(dp[i]==dp[p5]*5) p5++;
		}
		return dp[n-1];
	}
	
	
	public static void main(String[] args) {
		NthUglyNumber number = new NthUglyNumber();
		int i = number.nthUglyNumber(11);
		System.out.println(i);
	}
}
