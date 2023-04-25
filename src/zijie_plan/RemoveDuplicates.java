/**
 * 26. 删除有序数组中的重复项
 */
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        //利用升序 
        int index = 0;
        int left = 0,right = 1;
        while(right<nums.length){
            if(nums[left]!=nums[right]){
                nums[++left] = nums[right];
            }
            right++;
        }
        return left+1;
    }


    public int removeDuplicates1(int[] nums) {
        List<Integer> usedNums = new ArrayList<>();
        int index = 0;
        for(int num:nums){
            if(!usedNums.contains(num)){
                nums[index++] = num;
                usedNums.add(num);
            }
        }
        return index;
    }
}
