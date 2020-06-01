package office66;

import java.util.ArrayList;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 * 给你一个数组 candies 和一个整数 extraCandies ，
 * 其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，
 * 将额外的 extraCandies 个糖果分配给孩子们之后，
 * 此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多的糖果数目。
 * 
 * @author ZSM
 *
 * @time 2020年6月1日上午10:34:24
 */
public class KidsWithCandies {

	/**
	 * 找到x+y>=z 平衡
	 *@author ZSM
	 * @param candies
	 * @param extraCandies
	 * @return
	 */
	public List<Boolean> kidsWithCandies(int[] candies,int extraCandies){
		List<Boolean> result =  new ArrayList<>();
		if(candies==null || candies.length==0) {
			return result;
		}
		int max = candies[0];
		for(int i=1;i<candies.length;i++) {
			if(max<candies[i]) {
				max = candies[i];
			}
		}
		for(int i=0;i<candies.length;i++) {
			int maxCandies = candies[i]+extraCandies;
			if(maxCandies>=max) {
				result.add(true);
			}else {
				result.add(false);
			}
		}
		return result;
		
	}
}
