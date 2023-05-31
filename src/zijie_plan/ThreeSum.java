class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //采用三指针
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int k=0;k<len;k++){
            if(nums[k]>0){
                break;
            }
            if(k>0 && nums[k]==nums[k-1]){
                continue;
            }
            int left = k+1;
            int right = len-1;
            while(left<right){
                int temp = nums[k]+nums[left]+nums[right];
                if(temp<0){
                    while(left<right && nums[left]==nums[++left]);
                }else if(temp>0){
                    while(left<right && nums[right]==nums[--right]);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                }
            }
        }
        return res;
    }
}
