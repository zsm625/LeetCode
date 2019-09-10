package day_9_10;

public class DailyTemperatures {
public static void main(String[] args) {
	DailyTemperatures test = new DailyTemperatures();
	int[] T= {89,62,70,58,47,47,46,76,100,70};
	int[] result = test.dailyTemperatures(T);
	for(int i=0;i<result.length;i++) {
		System.out.println(result[i]);
		
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

}
