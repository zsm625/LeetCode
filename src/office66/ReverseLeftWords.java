package office66;

/**
 * 翻转字符串给定索引左边的字符到字符串最后
 * @author ZSM
 *
 * @time 2020年3月15日上午11:10:01
 */
public class ReverseLeftWords {

	public String reverseLeftWords(String s,int n) {
		if(s==null || s.length()==0 || n<=0) {
			return s;
		}
		String substring = s.substring(0, n);
		s = s.substring(n);
		s = s+substring;
		return s;
	}
	
	/**
	 * 
	 *@author ZSM
	 * @param s
	 * @param n
	 * @return
	 */
	public String reverseLeftWords2(String s,int n) {
		StringBuffer buffer=new StringBuffer(s.substring(n,s.length()));
        buffer.append(s.substring(0,n));
        return buffer.toString();
	}
}
