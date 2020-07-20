package office66;

/**
 * N个骰子出现的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * @author ZSM
 *
 * @time 2020年7月17日上午10:57:00
 */
public class NShaizi {

	/**
	 * 动态规划
	 * n个骰子可能出现的点数和有6n-(n-1)个
	 * 每个点数和出现的概率：出现次数/总的次数
	 * 如n=2，会出现2,      3,      4,      5,      6,     7,       8,      9,     10,     11,     12
	 *            0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public double[] twoSum(int n) {
		if(n==0) {
			return new double[0];
		}
		int [][]dp = new int[n+1][6*n+1];
        //边界条件
        for(int s=1;s<=6;s++)dp[1][s]=1;
        for(int i=2;i<=n;i++){
            for(int s=i;s<=6*i;s++){
                //求dp[i][s]
                for(int d=1;d<=6;d++){
                    if(s-d<i-1)break;//为0了
                    dp[i][s]+=dp[i-1][s-d];
                }
            }
        }
        double total = Math.pow((double)6,(double)n);
        double[] ans = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)dp[n][i])/total;
        }
        return ans;
	}
	public static void main(String[] args) {
		NShaizi shaizi = new NShaizi();
		double[] ds = shaizi.twoSum(2);
		for(int i=0;i<ds.length;i++) {
			System.out.println(ds[i]);
		}
	}
}
