package dailyquestion.d_2020_08_19;

/**
 * 回文子串
 * @author ZSM
 *
 * @time 2020年8月19日上午7:53:14
 */
public class CountSubstrings {

	/**
	 * 依次分解出长度大于2的子串，然后进行判断；
	 * 暴力解法
	 * 时间复杂度O(N*N*N)
	 * 空间复杂度O(1)
	 *@author ZSM
	 * @param s
	 * @return
	 */
	public int countSubstrings(String s) {
		if(s.length()==0) {
			return 0;
		}
		int res = s.length();
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
				if(isPalindrome(i,j,s)) {
					res++;
				}
			}
		}
		return res;
	}
	
	/**
	 * 只需要判断left 到 right这一段的string是回文串
	 *@author ZSM
	 * @param left
	 * @param right
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(int left,int right,String s) {
		while(left<=right) {
			if(s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	/**
	 * 中心扩展法
	 *@author ZSM
	 * @param s
	 * @return
	 */
	public int countSubstrings2(String s) {
		if(s.length()==0) {
			return 0;
		}
		int lens = 2*s.length()-1;
		int res = 0;
		for(int c=0;c<lens;c++) {
			int left = c/2;
			int right = left+c%2;
			while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
				left--;
				right++;
				res++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		CountSubstrings substrings = new CountSubstrings();
		int i = substrings.countSubstrings2("ababa");
		System.out.println(i);
	}
}
