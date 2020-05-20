package set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 圆圈里的最后一个数
 * 0,1,,n-1这n个数字排成一个圆圈，
 * 从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，
 * 从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，
 * 因此最后剩下的数字是3。
 * @author ZSM
 *
 * @time 2020年3月22日下午1:40:59
 */
public class LastRemaining {
	
	/**
	 * 不是很明白每个移除下标公式是c=（c0
	 * +m-1）%list.size();
	 *@author ZSM
	 * @param n
	 * @param m
	 * @return
	 */
	public int lastRemianing(int n,int m) {
		if(n==0 || m==0) {
			return -1;
		}
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(i);
		}
		int c = (m-1)%n;
		while(list.size()!=1) {
			list.remove(c);
			c = (c+m-1)%list.size();
		}
		return list.get(0);
	}
	
	public static void main(String[] args) {
		LastRemaining remaining = new LastRemaining();
		int i = remaining.lastRemianing(5, 3);
		System.out.println(i);
	}
}
