package dailyquestion.d_2020_09_01;

/**
 * 预测赢家
 * 给定一个表示分数的非负整数数组。 
 * 玩家 1 从数组任意一端拿取一个分数，
 * 随后玩家 2 继续从剩余数组任意一端拿取分数，
 * 然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数
 * ，分数被拿取之后不再可取。
 * 直到没有剩余分数可取时游戏结束。
 * 最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，
 * 预测玩家1是否会成为赢家。
 * 你可以假设每个玩家的玩法都会使他的分数最大化。
 * @author zsm
 *
 *     时间：2020年9月1日
 */
public class PredictTheWinner {

	public boolean predictTheWinner(int[] nums) {
		if(nums.length==0) {
			return false;
		}
		
		return help(nums,0,nums.length-1)>=0;
	}
	
	public int help(int[] nums,int i,int j) {
		if(i==j) {
			return nums[i];
		}
		int first = nums[i]-help(nums,i+1,j);
		int later = nums[j]-help(nums,i,j-1);
		return Math.max(first, later);
	}
	
	public boolean predictTheWinner2(int[] nums) {
		if(nums.length==0) {
			return false;
		}
		int[][] dp = new int[nums.length][nums.length];
		for(int i=0;i<nums.length;i++) {
			dp[i][i]=nums[i];
		}
		
		for(int i=nums.length-2;i>=0;i--) {
			for(int j=i+1;j<nums.length;j++) {
				int first = nums[i]-dp[i+1][j];
				int later = nums[j]-dp[i][j-1];
				dp[i][j]=Math.max(first, later);
			}
		}
		
		return dp[0][nums.length-1]>=0;
	}
}
