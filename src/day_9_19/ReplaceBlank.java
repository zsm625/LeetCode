package day_9_19;

/**
 * 将一个字符串中的空格替换成 "%20"。
 * 
 * @author ZSM
 *
 * @time 2019年9月22日上午11:26:40
 */
public class ReplaceBlank {

	/**
	 * 参数是String
	 * 
	 * @author ZSM
	 * @param str
	 * @return
	 */
	public String replaceBlank(String str) {

		str = str.replace(" ", "%20");
		return str;
	}

	public String replcaceBlank2(StringBuffer str) {
		/*
		 * System.out.println(str.length()); for(int i=0;i<str.length();i++) {
		 * if(str.charAt(i)==' ' && i<str.length()-1) { int len = str.length()+3;
		 * str.setLength(len); str.setCharAt(str.length()-1-i, str.charAt(i+1));
		 * 
		 * } }
		 */

		// 来自大神的解题,这个解答不正确
		int p = str.length() - 1;
		for (int i = 0; i < p; i++) {
			// 这里是，当遍历到字符串中有空格时，字符串后面任意拼接上2个字符，这里拼的是2个空格
			if (str.charAt(i) == ' ') {
				str.append("  ");

				// 得到新的字符长度
				int q = str.length() - 1;
				while (q >= 0 && q > p) {
					char c= str.charAt(p--);
					if(c==' ') {
						str.setCharAt(q--, '0');
						str.setCharAt(q--, '2');
						str.setCharAt(q--, '%');
					}else {
						str.setCharAt(q--, c);
					}
				}
			}
		}

		return str.toString();
	}

	public static void main(String[] args) {
		ReplaceBlank re = new ReplaceBlank();
		System.out.println(re.replaceBlank("A B c"));
		StringBuffer sb = new StringBuffer("A B c");
		System.out.println(re.replcaceBlank2(sb));
	}
}
