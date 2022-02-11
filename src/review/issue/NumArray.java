class NumArray {
    int[] dp;
    public NumArray(int[] nums) {
        int len = nums.length;
        dp = new int[len+1];
        dp[0]=nums[0];
        for(int i=1;i<len;i++){
            dp[i] = dp[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left <=0){
            return dp[right];
        }
        return dp[right] - dp[left-1];
    }
}
//21天打卡第二天
