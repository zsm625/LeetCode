package dailyquestion.d_2020_09_05;

import java.util.Arrays;

/**
 * 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 如：n=3，k=3，返回"213"
 * @author zsm
 *
 *     时间：2020年9月5日
 */
public class GetPermutation {

	//计算阶乘
	private int[] factorial ;
	private boolean[] used;
	private int k, n;
	/**
	 * 深度优先遍历—+剪枝
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation(int n,int k) {
		if(n>9 || n<1) {
			return "";
		}
		this.n = n;
		this.k = k;
		
		caculateFactorial(n);
		//查找全排列需要的布尔数组
		this.used = new boolean[n+1];
		Arrays.fill(used, false);
		
		StringBuilder sb = new StringBuilder();
		dfs(0,sb);
		return sb.toString();
	}
	
	public void dfs(int index,StringBuilder sb) {
		if(index == n) {
			return;
		}
		int cont = factorial[n-1-index];
		for(int i=1;i<=n;i++) {
			if(used[i]) {
				continue;
			}
			if(cont<k) {
				k-=cont;
				continue;
			}
			sb.append(i);
			used[i] = true;
			dfs(index+1,sb);
			return;
		}
	}
	
	/**
	 * 就算阶乘
	 * @param n
	 */
	public void caculateFactorial(int n) {
		this.factorial = new int[n+1];
		factorial[0]=1;
		for(int i=1;i<n+1;i++) {
			factorial[i] = factorial[i-1]*i;
		}
	}
	public static void main(String[] args) {
		GetPermutation permutation = new GetPermutation();
		String string = permutation.getPermutation(3, 3);
		System.out.println(string);
	}
}
