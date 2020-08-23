package dailyquestion.d_2020_08_23;
/**
 * 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，
 * 返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * @author Administrator
 *
 */
public class RangeBitwiseAnd {
	/**
	 * 纯数学题啊
	 * @param m
	 * @param n
	 * @return
	 */
	public int rangeBitwiseAnd(int m,int n) {
		if(m==0||n==0) {
			return 0;
		}
		int step = 0;
		while(m<n) {
			m=m>>1;
		    n=n>>1;
		    step++;
		}
		return m<<step;
	}

}
