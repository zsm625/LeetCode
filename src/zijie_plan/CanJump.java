class CanJump {
    public boolean canJump(int[] nums) {
        int max = 0;
        int len = nums.length;
        for(int i=0;i<= max;i++){
            int temp = i+nums[i];
            max = Math.max(temp,max);
            if(max>=len-1){
                return true;
            }
        }
        return false;

    }
}
