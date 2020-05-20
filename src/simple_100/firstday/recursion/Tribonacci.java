package simple_100.firstday.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 泰波那契序列 Tn 定义如下： 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * @author ZSM
 *
 * @time 2020年1月29日下午12:33:53
 */
public class Tribonacci {
	/**
	 * 递归:
	 * 最初使用的递归，由于数字过大，导致运行超时，之后使用一个map将之前已经计算的答案保存
	 * 下次用的时候直接取用
	 * 
	 *@author ZSM
	 * @param n
	 * @return
	 */
	Map<Integer,Integer> map = new HashMap<>(); 
	public int tribonacci(int n) {
		if(map.containsKey(n)) {
			return map.get(n);
		}
		if(n==0) {
			return 0;
		}
		if(n<=2) {
			return 1;
		}
		int res = tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1);
		map.put(n,res);
		return res;
	}

}
