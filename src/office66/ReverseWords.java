package office66;

/**
 * 翻转单词
 * 
 * @author ZSM
 *
 * @time 2020年4月10日上午10:32:02
 */
public class ReverseWords {
	/**
	 * 使用的是API来解决的，限制思维，而且没有考虑到去空格这个方法，导致一直通不过
	 * 
	 * @author ZSM
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		StringBuffer sb = new StringBuffer();
		String[] words = s.trim().split("( )+");
		for (int i = words.length - 1; i >= 0; i--) {
			if (i != 0) {
				sb.append(words[i]);
				sb.append(" ");
			} else {
				sb.append(words[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * 使用双指针来做
	 * 
	 * @author ZSM
	 * @param s
	 * @return
	 */
	public String reverseWords2(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		StringBuffer sb = new StringBuffer();
		s = s.trim();
		int j = s.length()-1,i=j;
		while(i>=0) {
			while(i>=0 && s.charAt(i)!=' ') {
				i--;
			}
			sb.append(s.substring(i+1, j+1)+" ");
			while(i>=0 && s.charAt(i)==' ') {
				i--;
			}
			j=i;
		}

		return sb.toString().trim();
	}
	
	

	public static void main(String[] args) {
		ReverseWords words = new ReverseWords();
		String word2 = words.reverseWords2("a good   example");
		System.out.print(word2);
	}

}
