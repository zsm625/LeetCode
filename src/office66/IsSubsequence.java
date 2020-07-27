package office66;

/**
 * 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。
 * 字符串 t 可能会很长（长度 ~= 500,000），
 * 而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符
 * 而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * @author ZSM
 *
 * @time 2020年7月27日上午7:51:34
 */
public class IsSubsequence {

	/**
	 * 双指针
	 *@author ZSM
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubsequence(String s,String t) {
		if(s.length()==0) {
			return true;
		}
		int right=0,i=0;
			while(right<t.length() && i<s.length()) {
				if(s.charAt(i)==t.charAt(right)) {
					i++;
				}
				right++;
			}
			return i==s.length();
	}
	
	public static void main(String[] args) {
		IsSubsequence subsequence = new IsSubsequence();
		boolean b = subsequence.isSubsequence("aec", "abadec");
		System.out.println(b);
	}
}
