package dailyquestion.d_2020_08_24;

/**
 * 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 如:"abab"  true
 *    "aba"  false
 * @author Administrator
 *
 */
public class RepeatedSubstringPattern {
	/**
	 * 暴力一一枚举
	 * 时间复杂度O(n*n)
	 * 空间复杂度O(1)
	 * @param s
	 * @return
	 */
	public boolean repeatedSubstringPattern(String s) {
		if(s.length()==0) {
			return false;
		}
		int len = s.length();
		for(int i=1;i*2<=len;i++) {
			if(len%i==0) {
				boolean match = true;
				for(int j=i;j<len;j++) {
					if(s.charAt(j)!=s.charAt(j-i)) {
						match = false;
						break;
					}
				}
				if(match) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean repeatedSubstringPattern2(String s) {
		if(s.length()==0) {
			return false;
		}
		return (s+s).indexOf(s, 1)!=s.length();
	}
	public static void main(String[] args) {
		RepeatedSubstringPattern pattern = new RepeatedSubstringPattern();
		pattern.repeatedSubstringPattern2("aba");
	}
}
