package office66;

/**
 * 最长无重复子字符串
 * 
 * @author ZSM
 *
 * @time 2020年3月19日下午5:39:28
 */
public class LengthOfLongestSubstring {
	private int head = 0,res=1;
	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		char[] chars = s.toCharArray();
		for(int tail=1;tail<s.length();tail++) {
			int max = 1;
			for(int j=tail-1;j>=head;j--) {
				if(chars[j]!=chars[tail]) {
					max++;
				}else {
					head = j+1;
				}
			}
			res = Math.max(res, max);
		}
		return res;
	}
	public static void main(String[] args) {
		LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
		int i = substring.lengthOfLongestSubstring("pwwekw");
		System.out.println(i);
	}
}
