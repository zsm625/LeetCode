class Rotate {
    public void rotate(int[] nums, int k) {
       // 用空间换时间
       int len = nums.length;
       int[] newArr = new int[len];
       for(int i = 0;i<len;i++){
           newArr[(i+k) % len] = nums[i];
       }
       for(int i=0;i<len;i++){
           nums[i] = newArr[i];
       }

    }
}
