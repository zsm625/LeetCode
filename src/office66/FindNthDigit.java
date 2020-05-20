package office66;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 
 * @author ZSM
 *
 * @time 2020年3月28日下午4:47:37
 */
public class FindNthDigit {

	/**
	 * 0-9 10 
	 * 10-99 90*2=180 
	 * 100-999 900*3 = 2700
	 * 如第368个数 368-10-180=178
	 * 也就是说368是三位数中的178位 178/3+1=59; 
	 * 算出具体数值是100+59=159；
	 * 
	 * @author ZSM
	 * @param n
	 * @return
	 */
	public int findNthDigit(int n) {
		if (n < 0) {
			return -1;
		}
		if (n <= 9) {
			return n;
		}

		return nthDigit(n);
	}

	/**
	 * 返回当前给的数在几位数中的第几个值 直接从n>10之后开始算
	 * 
	 * @author ZSM
	 * @param digit
	 * @return
	 */
	private int nthDigit(int n) {
		int b = 2;
		n=n-10;
		int i = 9 * b * (int) Math.pow(10, b-1);
		while (n > i) {
			n = n - i ;
			b++;
			if(9 * b * Math.pow(10, b-1)>Integer.MAX_VALUE) {
				i = Integer.MAX_VALUE;
			}else {
				i = 9 * b * (int) Math.pow(10, b-1);
			}
		}
		// 具体数值
			int digit = (int) (n / b + Math.pow(10, b - 1));
		// 具体数值中的第几位
		int index = n % b;
		int num = 0;
		while (index != -1) {
			num = digit / (int) Math.pow(10, b - 1);
			digit = digit % (int) Math.pow(10, b - 1);
			index--;
			b--;
		}
		return num;
	}

	public static void main(String[] args) {
		FindNthDigit digit = new FindNthDigit();
		int n = 1000000000;
		int i = digit.findNthDigit(n);
//		System.out.println(9*Math.pow(10, 9)>Integer.MAX_VALUE);
		System.out.println(i);
	}
}
