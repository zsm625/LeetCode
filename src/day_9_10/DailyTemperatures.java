package day_9_10;

import java.util.Stack;

public class DailyTemperatures {
public static void main(String[] args) {
	DailyTemperatures test = new DailyTemperatures();
	int[] T= {89,62,70,58,47,47,46,76,100,70};
	int[] result = test.dailyTemperatures3(T);
	//8154321100
	//8154321100
	for(int i=0;i<result.length;i++) {
		System.out.print(result[i]);
		
	}
}
	/**
	 * 第一种暴力解法 时间O(n^2)
	 * 留一个 明天的作业，使用优化版的
	 *@author ZSM
	 * @param T
	 * @return
	 */
	public int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
		if (T.length >= 1 && T.length <= 30000) {
			result[T.length - 1] = 0;
			// 倒序遍历
			for (int i = T.length - 2; i >= 0; i--) {
				if (T[i] < T[i + 1]) {
					result[i] = 1;
				}
				if (T[i] >= T[i + 1]) {
					if (i < T.length - 2) {
						for (int j = i + 2; j < T.length; j++) {
							if (T[i] < T[j]) {
								result[i]=j-i;
								break;
							}
						}
					}else {
						result[i]=0;
					}

				}
			}
		}
		return result;
	}
	
	
	/**
	 * 第二种使用跳跃式对比的遍历，第一种是在中间会有多次重复的遍历，优化，可以在这个点出发，减少遍历次数
	 * 
	 *@author ZSM
	 * @param T
	 * @return
	 */
	public int[] dailyTemperatures2(int[] T) {
		int[] result = new int[T.length];
		result[T.length-1]=0;
		for(int i=T.length-2;i>=0;i--) {
			
			for(int j=i+1;j<T.length;j+=result[j]) {
				if(T[j]>T[i]) {
				result[i]=j-i;	
				break;
				}else if(result[j]==0) {
					result[i]=0;
					break;
				}
			}
		}
		
		return result;
	}
	
	
	/**
	 * 第三种使用栈 往栈里扔下标
	 *@author ZSM
	 * @param T
	 * @return
	 */
	public int[] dailyTemperatures3(int[] T) {
		int[] result = new int[T.length];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<T.length-1;i++) {
			//89,62,70,58,47,47,46,76,100,70
			stack.push(i);
			for(int j=i+1;j<T.length;j++) {
				if(T[i]<T[j]) {
					result[i]=j-i;
					stack.pop();
					break;
				}
			}
			
		}
		
		return result;
	}

}
