package office66;

/**
 * 分发糖果
 * 
 * @author ZSM
 *
 * @time 2020年3月5日下午3:28:55
 */
public class DistributeCandies {

	/**
	 * 这个方法的妙处是：i%num_people的取余刚刚好是数组的索引号，
	 * 这样可以不用再处理新一轮的索引变化
	 * 
	 *@author ZSM
	 * @param candies
	 * @param num_people
	 * @return
	 */
	public int[] distributeCandies(int candies, int num_people) {
		int[] ans = new int[num_people];
		int i=0;
		while(candies!=0) {
			if(candies>=(i+1)) {
				ans[i%num_people]+= (i+1);
				candies-=i+1;
			}else {
				ans[i%num_people] += candies;
				candies-=candies;
			}
			i++;
		}
		return ans;
	}
	public static void main(String[] args) {
		DistributeCandies candies = new DistributeCandies();
		int[] is = candies.distributeCandies(60, 4);
		for(int i=0;i<is.length;i++) {
			System.out.print(is[i]+"\t");
		}
	}
}
