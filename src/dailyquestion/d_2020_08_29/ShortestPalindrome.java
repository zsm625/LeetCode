package dailyquestion.d_2020_08_29;

/**
 * 最短回文串
 * @author zsm
 *
 *     时间：2020年8月29日
 */
public class ShortestPalindrome {

	/**
	 * KMP算法  难啊
	 * @param s
	 * @return
	 */
	public String shortestPalindrome(String s) {
	    String ss = s + '#' + new StringBuilder(s).reverse();
	    int max = getLastNext(ss);
	    return new StringBuilder(s.substring(max)).reverse() + s;
	}

	//返回 next 数组的最后一个值
	public int getLastNext(String s) {
	    int n = s.length();
	    char[] c = s.toCharArray();
	    int[] next = new int[n + 1];
	    next[0] = -1;
	    next[1] = 0;
	    int k = 0;
	    int i = 2;
	    while (i <= n) {
	        if (k == -1 || c[i - 1] == c[k]) {
	            next[i] = k + 1;
	            k++;
	            i++;
	        } else {
	            k = next[k];
	        }
	    }
	    return next[n];
	}
}
