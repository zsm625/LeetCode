class Jump {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        //暴力遍历
        int step = 0;
        int maxDis = 0;
        int end = 0;
        for(int i=0;i<nums.length-1;i++){
            maxDis = Math.max(i+nums[i],maxDis);
            if(i==end){
                end = maxDis;
                step++;
            }
        }
        return step;
    }
}
