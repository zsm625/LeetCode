package office66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 
 * @author ZSM
 *
 * @time 2020年4月16日下午5:12:53
 */
public class MergeArrays {
	
	public int[][] merge(int[][] intervals){
		List<int[]> res = new ArrayList<>();
		if(intervals==null || intervals.length==0 ) {
			return new int[0][];
		}
		//将数组按照第一个数字从小到大排列
		Arrays.sort(intervals,(a,b)->a[0]-b[0]);
		
		int i =0;
		while(i<intervals.length) {
			int left = intervals[i][0];
			int right = intervals[i][1];
			while(i<intervals.length-1 && intervals[i+1][0]<=right) {
				i++;
				right=Math.max(right, intervals[i][1]);
			}
			res.add(new int[] {left,right});
			i++;
		}
		return res.toArray(new int[0][]);
		
	}

}
