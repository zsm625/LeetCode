class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left<=right){
            int min = left+(right-left)/2;
            if(target<nums[min]){
                if( min==left){
                    if(target>nums[left]){
                       return min+1;
                    }else if(target<nums[left]){
                        return left;
                    }
                }
                
                 right = min-1;
            }else if(target>nums[min]){
                if(min==right){
                    return min+1;
                }
                left = min+1;
            }else{
                return min;
            }
        }
        return -1;
    }
}
