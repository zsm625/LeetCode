class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        if(nums.length<2){
            return new int[0];
        }
        for(int i=0;i<nums.length;i++){
            int val = target - nums[i];
            if(map.containsKey(val)){
                int temp = map.get(val);
                return new int[]{temp,i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
