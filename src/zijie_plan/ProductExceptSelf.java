class ProductExceptSelf {
    public int[] productExceptSelf1(int[] nums) {
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
     public int[] productExceptSelf2(int[] nums) {
        //换一种，题目要求不能使用除法 分别获取左右两边的乘积
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0]= 1;
        right[n-1]=1;
        int[] answer = new int[n];
        for(int i=1;i<n;i++){
            left[i] = nums[i-1]*left[i-1];
        }
        for(int i=n-2;i>=0;i--){
            right[i] = nums[i+1]*right[i+1];
        }
        for(int i=0;i<n;i++){
            answer[i] = right[i]*left[i];
        }
        return answer;
    }
    
}
