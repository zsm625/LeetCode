package office66;

/**
 * 是否是回文数
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @author ZSM
 *
 * @time 2020年6月10日下午6:19:04
 */
public class IsPalindrome {

	/**
	 * 就很普通的数学方法
	 * 
	 *@author ZSM
	 * @param num
	 * @return
	 */
	public boolean isPalindrome(int num) {
		if(num>=0&&num<=9) {
			return true;
		}
		if(num<0) {
			return false;
		}
		int n = num;
		int res = 0;
		while(n>=10) {
			int yushu = n%10;
			res=(res+yushu)*10;
			n=n/10;
		}
		res+=n;
		if(res==num) {
			return true;
		}else {
			return false;
		}
		
	}
	public static void main(String[] args) {
		IsPalindrome palindrome = new IsPalindrome();
		boolean b = palindrome.isPalindrome(313);
		System.out.println(b);
	}
}
