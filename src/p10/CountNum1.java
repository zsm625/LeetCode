package p10;

/**
 * 计算一个数的二进制数的1的个数
 * @author ZSM
 *
 * @time 2019年10月5日下午2:45:09
 */
public class CountNum1 {

	/**
	 * 采用位运算
	 * n&（n-1）当n！=0时，n-1，的最后一位一定会是1，
	 * 当两个二进制数进行与运算时，n的1有多少个就可以有多少次运算
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int NumberOf1(int n) {
		int count =0;
		while(n!=0) {
			count++;
			n=n&(n-1);
		}
		return count;
    }
	
	/**
	 * 使用了Java自带的方法库
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int numberOf2(int n) {
		
		return Integer.bitCount(n);
	}
	public static void main(String[] args) {
		CountNum1 num1 = new CountNum1();
		System.out.println(num1.numberOf2(4));
	}
}
