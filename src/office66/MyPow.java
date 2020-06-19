package office66;

/**
 * 实现函数double Power(double base, int exponent)，
 * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 
 * @author ZSM
 *
 * @time 2020年6月19日下午5:28:07
 */
public class MyPow {
	/**
	 * 位运算
	 * 在这里需要注意的一点是，Java中的int范围是-2147483648，2147483647
	 * 因此要使用一个long型来保存n，保证转换为正整数时不会溢出
	 *@author ZSM
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x,int n ) {
		double res = 1.0;
		long b = n;
		if(b<0) {
			x=1/x;
			b=-b;
		}
		while(b>0) {
			if((b&1)==1) {
				res*=x;
			}
			x*=x;
			b>>=1;
		}
		return res;
	}
	public static void main(String[] args) {
		MyPow pow = new MyPow();
		//2.00000
		//-2147483648
		double d = pow.myPow(2.00000, -2147483648);
		System.out.println(d);
	}
}
