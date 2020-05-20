package office66;

/**
 * 统计优美数组
 * 
 * @author ZSM
 *
 * @time 2020年4月21日下午8:26:48
 */

public class NumberOfSubarrays {
	public int numberOfSubarrays(int[] nums,int k) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		int left = 0, right = 0, oddCnt = 0, res = 0;
        while (right < nums.length) {
            // 右指针先走，每遇到一个奇数则 oddCnt++。
            if ((nums[right++] & 1) == 1) {
                oddCnt++;
            }

            //  若当前滑动窗口 [left, right) 中有 k 个奇数了，进入此分支统计当前滑动窗口中的优美子数组个数。
            if (oddCnt == k) {
                // 先将滑动窗口的右边界向右拓展，直到遇到下一个奇数（或出界）
                // rightEvenCnt 即为第 k 个奇数右边的偶数的个数
                int tmp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int rightEvenCnt = right - tmp;
                // leftEvenCnt 即为第 1 个奇数左边的偶数的个数
                int leftEvenCnt = 0;
                while ((nums[left] & 1) == 0) {
                    leftEvenCnt++;
                    left++;
                }
                // 第 1 个奇数左边的 leftEvenCnt 个偶数都可以作为优美子数组的起点
                // (因为第1个奇数左边可以1个偶数都不取，所以起点的选择有 leftEvenCnt + 1 种）
                // 第 k 个奇数右边的 rightEvenCnt 个偶数都可以作为优美子数组的终点
                // (因为第k个奇数右边可以1个偶数都不取，所以终点的选择有 rightEvenCnt + 1 种）
                // 所以该滑动窗口中，优美子数组左右起点的选择组合数为 (leftEvenCnt + 1) * (rightEvenCnt + 1)
                res += (leftEvenCnt + 1) * (rightEvenCnt + 1);

                // 此时 left 指向的是第 1 个奇数，因为该区间已经统计完了，因此 left 右移一位，oddCnt--
                left++;
                oddCnt--;
            }

        }

        return res;

	}
	
	public int numberOfSubarray(int[] nums,int k) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		int left = -1;
		int right = -1;
		int count = 0;
		int res = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2!=0) {
				if(left==-1) {
					left=i;
				}
				count++;
			}
			if(count==k) {
				right = i;
				res += 1+left+left*(nums.length-right)+nums.length-right;
				count--;
				left++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		NumberOfSubarrays subarrays = new NumberOfSubarrays();
		int[] nums = {1,1,2,1,1};
		int i = subarrays.numberOfSubarrays(nums, 4);
		System.out.println(i);
	}
}
