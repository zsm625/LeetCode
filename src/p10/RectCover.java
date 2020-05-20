package p10;

import java.util.Iterator;

/**
 * 矩形覆盖：
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，
 * 总共有多少种方法？
 * @author ZSM
 *
 * @time 2019年10月3日下午12:13:20
 */
public class RectCover {

	public int rectCover(int n) {
		if(n<=1) {
			return n;
		}
		
		int pre1 = 1;
		int pre2 = 2;
		for(int i=3;i<=n;i++) {
			int cur  = pre1+pre2;
			pre1= pre2;
			pre2 = cur;
		}
		
		return pre2;
	}
	
	/**
	 * 大佬的答案
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int rectCover2(int n) {
	    if (n <= 2)
	        return n;
	    int pre2 = 1, pre1 = 2;
	    int result = 0;
	    for (int i = 3; i <= n; i++) {
	        result = pre2 + pre1;
	        pre2 = pre1;
	        pre1 = result;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		RectCover cover = new RectCover();
		System.out.println(cover.rectCover2(6));
	}
}
