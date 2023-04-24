class RemoveElements {
    public int removeElement(int[] nums, int val) {
        //双指针
        //一个指针遍历，一个指针标识被替换的为止
        int point = 0;
        for(int n:nums){
            if(n!=val){
                nums[point++] = n;
            }
        }
        return point;
    }

    private int removeElement1(int[] nums,int val){
        int len = nums.length;
        int index = 0;
        int tab = -1;
        boolean first = true;
        while(index<nums.length){
            if(nums[index] == val){
                len--;
                nums[index] = 0;
                if(first){
                    first = false;
                    tab = index;
                }
            }else{
                 if(tab!=-1){
                    nums[tab] = nums[index];
                    tab++;
                }
            }
           
            index++;
        }
        return len;
    }
}
