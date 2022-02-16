class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len<=0){
            return new int[]{-1,-1};
        }
        int left=0;
        int right= len-1;
        int[] res = new int[]{-1,-1};
        //左边界
        while(left<right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target){
                right = mid;
            }else if(nums[mid]>target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        if(nums[right]!=target){
            return res;
        }
        res[0] = right;
        //右边界
        left = right;
        right = len;
        while(left<right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        res[1] = left-1;
        return res;
    }
}
