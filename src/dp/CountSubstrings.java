package dp;

/**
 * 计算回文子串
 * @author ZSM
 *
 * @time 2019年9月12日下午11:05:44
 */
public class CountSubstrings {
	int result =0;
	public int countSubstrings(String str) {
		
		for(int i=0;i<str.length();i++) {
			count(str,i,i);//这个是回文长度为奇数
			count(str,i,i+1);//回文长度是偶数
		}
		
		return result;
	}
	
	public void count(String str,int start,int end) {
		while(start>=0 && end<str.length() && str.charAt(start)==str.charAt(end)) {
			result++;
			start--;
			end++;
			
		}
		
	}
	
	public static void main(String[] args) {
		CountSubstrings substrings = new CountSubstrings();
		System.out.println(substrings.countSubstrings("aba"));
	}
}
