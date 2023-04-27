class RemoveDuplicates1 {
    public int removeDuplicates(int[] nums) {
        //快慢指针
        int n = nums.length;
        if(n<=2){
            return n;
        }
        int slow = 2;
        int fast = 2;
        while(fast<n){
            if(nums[slow-2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
