package office66;

/**
 * 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 
 * @author ZSM
 *
 * @time 2020年3月19日下午4:53:45
 */
public class LongestPalindrome {
	
	/**
	 * 思路：
	 * 先使用一个数组记录每个字符出现的次数
	 * 当ch出现的次数为v时，那么它可以被使用v/2 *2 次，
	 * 当ch出现的次数为v/2==1时，可以将ch作为中间的字符
	 *@author ZSM
	 * @param s
	 * @return
	 */
	public int longestPalindrome(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		int[] char_count = new int[52];
		boolean b = true;
		int sum=0;
		//记录char出现的次数
		for (char ch:s.toCharArray()) {
			char_count[ch-'A']++;
		}
		
		for(int count:char_count) {
			sum +=(count/2)*2 ;
			if(count%2==1 && b) {
				sum+=1;
				b=false;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		LongestPalindrome l = new LongestPalindrome();
		int i = l.longestPalindrome("AbcddA");
		System.out.println(i);
	}
}
