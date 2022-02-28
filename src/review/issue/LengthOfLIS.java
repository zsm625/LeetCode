class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {   
        int len = nums.length;
        if(len<=0){
            return 0;
        }
        if(len==1){
            return 1;
        }
        //明确状态
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for(int i=0;i<len;i++){
            for(int k=0;k<i;k++){
                if(nums[i]>nums[k]){
                    dp[i] = Math.max(dp[i],dp[k]+1);
                }
            }
        }
        int res = 0;
        for(int i=0;i<len;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
