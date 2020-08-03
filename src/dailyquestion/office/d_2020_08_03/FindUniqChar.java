package dailyquestion.office.d_2020_08_03;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。 s 只包含小写字母。
 * @author ZSM
 *
 * @time 2020年8月3日下午2:02:47
 */
public class FindUniqChar {
	/**
	 * 有序hash表
	 *@author ZSM
	 * @param s
	 * @return
	 */
	public char findUniqChar(String s) {
		Map<Character, Boolean> dic = new LinkedHashMap<>();
	    char[] sc = s.toCharArray();
	    for(char c : sc)
	        dic.put(c, !dic.containsKey(c));
	    for(Map.Entry<Character, Boolean> d : dic.entrySet()){
	       if(d.getValue()) return d.getKey();
	    }
	    return ' ';
	}
}
