package office66;

import java.lang.reflect.Array;

/**
 * 剪绳子1
 * 给你一根长度为 n 的绳子，
 * 请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，
 * 我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18
 * @author ZSM
 *
 * @time 2020年5月21日上午10:51:47
 */
public class CuttingRope {

	/**
	 * 动态规划
	 * 当数据量不大时
	 * 
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int cuttingRope(int n) {
		if(n<1) {
			return 0;
		}
		int[] dp =new int[n+1];
		for(int i=0;i<n+1;i++) {
			dp[i]=1;
		}
		for(int i=3;i<=n;i++) {
			for(int j=1;j<=i-1;j++) {
				dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
			}
		}
		return dp[n];
	}
	
	/**
	 * 别人的解法总是那么的奇妙
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int cuttingRope2(int n) { 
		if(n<=3) return n-1;
		long res = 1;
		while(n>4) {
			res*=3;
			res = res%1000000007;
			n-=3;
		}
		return (int)(res*n%1000000007);
	}
	
	public static void main(String[] args) {
		CuttingRope rope = new CuttingRope();
		int i = rope.cuttingRope(120);
		System.out.println(i);
	}
}
