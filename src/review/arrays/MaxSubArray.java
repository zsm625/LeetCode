class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length<=0){
            return -1;
        }
        int max = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(sum<nums[i]){
                sum = nums[i];
            }
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }
}
