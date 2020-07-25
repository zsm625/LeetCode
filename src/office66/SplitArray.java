package office66;

/**
 * 分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，
 * 你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * @author ZSM
 *
 * @time 2020年7月25日上午7:48:10
 */
public class SplitArray {
	
	/**
	 * 二分查找
	 * 目标值会在区间（max(nums),sum(nums))中，
	 * 令l=sum(nums),h=max(nums),mid=l+(l-h)/2
	 * 计算数组和最大值不大于mid对应的子数组个数 cnt(这个是关键！)
	 * 如果l>mid,说明切多了，l=mid+1；
	 * 否则h=mid，最后返回l
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int splitArray(int[] nums,int m) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		long l=0,h=0;
		for(int num:nums) {
			h+=num;
			l = l>num?l:num;
		}
		while(l<h) {
			long mid = l+(h-l)/2;
			//cnt用来标识当前分割的数组个数
			int cnt = 1;
			int temp = 0;
			for(int num:nums) {
				temp+=num;
				if(temp>mid) {
					temp=num;
					cnt++;
				}
			}
			if(cnt>m) {
				l = mid+1;
			}else {
				h=mid;
			}
			
		}
		return (int)l;
	}

}
