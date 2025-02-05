class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1){
            return;
        }
       //第二种方式双指针
       int left = 0;
       for(int i=0;i<nums.length;i++){
           if(nums[i]!=0){
              nums[left++]=nums[i];
           }
       }
       for(int i=left;i<nums.length;i++){
        nums[i]=0;
       }
        
    }

    private void moveZeroes1(int[] nums){
         //第一种方式:空间换时间,用多一个数组 题目要求在不复制数组的情况下对原数组进行操作
        int[] copy = new int[nums.length];
        int zeroIndex = nums.length-1;
        int copyIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                copy[zeroIndex--] = 0; 
            }else{
                copy[copyIndex++]=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=copy[i];
        }
    }
}
