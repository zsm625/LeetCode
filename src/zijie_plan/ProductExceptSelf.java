class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zeroCnt = 0;
        //暴力遍历 将总乘积得出，剔除为0的特殊例子 虽然代码low，但是自己的孩子不嫌弃 
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCnt ++;
            }else{
                total*=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(zeroCnt == 0){
                nums[i] = total/nums[i];
            }else{
                if(zeroCnt>1){
                    nums[i]=0;
                }else if(zeroCnt==1 && nums[i]==0){
                    nums[i]=total;
                }else{
                    nums[i] = 0;
                }
            }
        }
        return nums;
    }
}
