class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // 用hashmap将数字出现次数存储起来
        int length = nums.length;
        List<List<Integer>> res = new ArrayList();
         for(int i=0;i<=length-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                //重复的元素跳过
                continue;
            }
            //三指针依次查找
            int first = i;
            int second = i+1;
            int third = length-1;
            while(second<length-1 && second<third){
                List<Integer> sumResult = new ArrayList<>();
                int target = nums[first]+nums[third]+nums[second];
                if(target<0 ){
                    second++;
                }else if(target >0){
                    third--;
                }else{
                    sumResult.add(nums[first]);
                    sumResult.add(nums[second]);
                    sumResult.add(nums[third]);
                    res.add(sumResult);
                    while(second<third && nums[second] == nums[second+1]){
                        second++;
                    }
                    while(second<third && nums[third] == nums[third-1]){
                        third--;
                    }
                    second++;
                    third--;
                }
            }
         }
         return res;

    }
}
