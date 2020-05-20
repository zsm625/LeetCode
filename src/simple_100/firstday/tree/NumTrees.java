package simple_100.firstday.tree;

/**
 * 给定一个数字，求以1，2,3，。。。n为节点的二叉搜索树有多少个
 * @author ZSM
 *
 * @time 2020年1月29日下午12:12:45
 */
public class NumTrees {

	/**
	 * 思路：动态规划
	 * 1、n个节点的二叉搜索树为f(n)
	 * 2、以i为节点的左子树有（i-1），右子树有（n-i）个
	 * 则G（i）=f(i-1)*f(n-i);
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<n+1;i++) {
			for(int j = 1;j<i+1;j++) {
				dp[i]+=dp[j-1]*dp[i-j];
			}
		}
		return dp[n];
	}
}
