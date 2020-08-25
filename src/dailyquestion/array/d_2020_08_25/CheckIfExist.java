package dailyquestion.array.d_2020_08_25;

/**
 * Check If N and Its Double Exist
 * Given an array arr of integers, 
 * check if there exists two integers N and M 
 * such that N is the double of M ( i.e. N = 2 * M). 
 * 检查数组是否存在N =2*M,m、n均为数组中元素
 * @author Administrator
 *
 */
public class CheckIfExist {

	public boolean checkIfExist(int[] nums) {
		if(nums.length==0) {
			return false;
		}
		
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums.length;j++) {
				if(i==j) {
					continue;
				}
				if(nums[i]*2==nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
}
