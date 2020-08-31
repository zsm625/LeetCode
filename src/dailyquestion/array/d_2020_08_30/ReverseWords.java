package dailyquestion.array.d_2020_08_30;

/**
 * reverse Words 
 * 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * @author zsm
 *
 *     时间：2020年8月30日
 */
public class ReverseWords {

	 public String reverseWords(String s) {
		 String[] split = s.split(" ");
		 StringBuilder sb = new StringBuilder();
		 for(int i=0;i<split.length;i++) {
			 sb.append(reverse(split[i]));
			 if(i!=split.length-1) {
				 sb.append(" ");
			 }
		 }
		 return sb.toString();
	 }
	 
	 public String reverse(String s) {
		 StringBuilder sb = new StringBuilder();
		 for(int i = s.length()-1;i>=0;i--) {
			 sb.append(s.charAt(i));
		 }
		 return sb.toString();
	 }
}
