package dp;

import java.util.Arrays;

/**
 * 动态规划算法的案例
 * 1、爬楼梯
 * @author ZSM
 *
 * @time 2019年9月12日下午11:01:01
 */
public class ClimbingStairs {

	 private int[] memo;

	    public int climbStairs(int n) {
	        memo = new int[n+1];
	        Arrays.fill(memo, -1);
	        return calcWays(n);
	    }

	    private int calcWays(int n){

	        if(n == 0 || n == 1)
	            return 1;

	        if(memo[n] == -1)
	            memo[n] = calcWays(n - 1) + calcWays(n - 2);

	        return memo[n];
	    }

	    public static void main(String[] args) {

	        System.out.println((new ClimbingStairs()).climbStairs(4));
	    }
}
