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
     public void rotate2(int[] nums, int k) {
       // 把要轮转的数组看成一个环，每次移动步数，最后到达原点就不退出
       int len = nums.length;
       if(len < 0){
           return;
       }
       int cnt = 0;
       for(int i = 0;i<len;i++){
           int temp = nums[i];
           int n = i;
           while(n<len){
           int tmp = nums[(n+k) % len];
           nums[(n+k) % len] = temp;
           temp = tmp;
           cnt++;
           if((n+k) % len == i){
               break;
              }
             n = (n+k) % len;
          }
          if(cnt == len){
              break;
          }
       }
       
       

    }
}
