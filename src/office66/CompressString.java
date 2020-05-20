package office66;

/**
 * 压缩字符串
 * @author ZSM
 *
 * @time 2020年3月16日上午11:35:05
 */
public class CompressString {

	public String compressString(String s) {
		if(s==null || s.length()==0) {
			return null;
		}
		char[] chars = s.toCharArray();
		StringBuffer res = new StringBuffer();
		int count = 1;
		char ch = chars[0];
		for(int i =1;i<chars.length;i++) {
			if(ch!=chars[i]) {
				res.append(ch);
				res.append(count);
				ch = chars[i];
				count=0;
			}
			count++;
			if(i==chars.length-1) {
				res.append(chars[i]);
				res.append(count);
			}
		}
		if(res.length()>s.length()) {
			return s;
		}
			
		return res.toString();
	}
	
	public static void main(String[] args) {
		CompressString string = new CompressString();
		String s = string.compressString("abbccdd");
		System.out.println(s);
	}
}
