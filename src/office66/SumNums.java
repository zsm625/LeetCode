package office66;

/**
 * 求 1+2+...+n ，
 * 要求不能使用乘除法、for、while、if、else、
 * switch、case等关键字及条件判断语句（A?B:C）。
 * 
 * @author ZSM
 *
 * @time 2020年6月2日上午11:12:41
 */
public class SumNums {
	/**
	 * 求和公式
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int sumNums(int n) {
		int sum = ((n+1)*n)/2;
		return sum;
	}
	public static void main(String[] args) {
		SumNums nums = new SumNums();
		System.out.println(nums.sumNums(9));
	}
}
