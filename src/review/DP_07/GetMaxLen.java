class GetMaxLen {
    public int getMaxLen(int[] nums) {
        int len = nums.length;
        if(len<=0 || len==1 && nums[0]<0){
            return 0;
        }
        if(len==1 && nums[0]>0){
            return 1;
        }
        int max = 0;
        int[] positive = new int[len];
        int[] negitive = new int[len];
        if(nums[0]>0){
            positive[0]=1;
            max=1;
        }
        if(nums[0]<0){
            negitive[0]=1;
        }
        for(int i=1;i<len;i++){
            if(nums[i]>0){
                positive[i]=positive[i-1]+1;
                negitive[i]=negitive[i-1]>0?negitive[i-1]+1:0;
            }else if(nums[i]<0){
                positive[i]=negitive[i-1]>0?negitive[i-1]+1:0;
                negitive[i]=positive[i-1]+1;
            }else{
                positive[i]=0;
                negitive[i]=0;
            }
            max = positive[i]>max?positive[i]:max;
        }
        return max;
    }
}
