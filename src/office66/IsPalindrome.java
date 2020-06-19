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
	
	/**
	 * 给定一个字符串，验证它是否是回文串，
	 * 只考虑字母和数字字符，可以忽略字母的大小写。
	 * 
	 * 在原字符串上进行操作，采用双指针的方式，head指针从前边慢慢遍历，trail指针从最后开始遍历
	 * 直到head>=trail
	 * 其中，在原字符串上遍历需要注意的是如果遇到不是字符或者数字的就需要跳过，进入下一个字符
	 * 采用了Character类中的方法来判断
	 *@author ZSM
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		if(s==null) {
			return false;
		}
		char[] chars = s.toCharArray();
		int head=0,trail = s.length()-1;
		while(head<=trail) {
			while(!Character.isLetterOrDigit(chars[head])) {
				if(head>=chars.length-1) {
					break;
				}
				head++;
			}
			while(!Character.isLetterOrDigit(chars[trail])) {
				if(trail<=0) {
					break;
				}
				trail--;
			}
			if((head<=trail)&&Character.toLowerCase(chars[head])!=Character.toLowerCase(chars[trail])) {
				return false;
			}
			head++;
			trail--;
		}
		return true;
	}
	public static void main(String[] args) {
		IsPalindrome palindrome = new IsPalindrome();
//		boolean b = palindrome.isPalindrome(313);
//		System.out.println(b);
		boolean c = palindrome.isPalindrome(".,");
		System.out.println(c);
	}
}
