package p10;

/**
 * 剪绳子：经典的动态规划和贪心算法题
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 * @author ZSM
 *
 * @time 2019年10月5日上午10:47:51
 */
public class CutRope {

	/**
	 * 贪心
	 * 首先找规律，得出当绳子剪为3或者2时，可得到的乘积是最大的；
	 *  
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int cutRopeGetMaxMutilValue(int n) {
		if(n<=1) {
			return 0;
		}
		if(n==2) {
			return 1;
		}
		if(n==3) {
			return 2;
		}
		int timeOfThree = n/3;
		if(n-timeOfThree*3 ==1) {
			timeOfThree --;
		}
		int timeOfTwo = (n-timeOfThree*3)/2;
		
		int result =(int)(Math.pow(3, timeOfThree)*Math.pow(2, timeOfTwo));
		
		return result;
	}
}
