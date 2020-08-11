package dailyquestion.d_2020_08_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 计数二进制子串
 * @author ZSM
 *
 * @time 2020年8月10日上午7:55:33
 */
public class CountBinarySubstrings {

	/**
	 * 给字符串分组，将连续的相同数字统计
	 * 如：001110011 ————>[2,3,2,2],然后对这些数组的数字进行叠加
	 *@author ZSM
	 * @param s
	 * @return
	 */
	public int countBinarySubstrings(String s) {
		if(s.length()==0) {
			return 0;
		}
		List<Integer> list = new  ArrayList<>();
		int i = 0, len = s.length();
		while(i<len) {
			char c = s.charAt(i);
			int count = 0;
			while(i<len && c==s.charAt(i)) {
				i++;
				count++;
			}
			list.add(count);
		}
		int res = 0;
		for (int j=1;j<list.size();j++) {
			res+=Math.min(list.get(j), list.get(j-1));
		}
		return res;
	}
	
	/**
	 * 
	 *@author ZSM
	 * @param s
	 * @return
	 */
	public int countBinarySubstring2(String s) {
		if(s.length()==0) {
			return 0;
		}
		int i=0,len = s.length();
		int ans = 0,last = 0;
		while(i<len) {
			char c = s.charAt(i);
			int counts = 0;
			while(i<len&& c==s.charAt(i)) {
				counts++;
				i++;
			}
			ans+=Math.max(counts, last);
			last = counts;
		}
		return ans;
	}
}
