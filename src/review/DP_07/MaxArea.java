class MaxArea {
    public int maxArea1(int[] height) {
        //暴力遍历 时间通不过
        int len = height.length;
        if(len<=1){
            return 0;
        }
        int[][] dp = new int[len][len];
        dp[0][0] = 0;
        int max = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int left = height[i];
                int right = height[j];
                if(left<=right){
                    dp[i][j] = left*(j-i);
                }else{
                    dp[i][j] = right*(j-i);
                }
                max = dp[i][j]>max?dp[i][j]:max;
            }
        }
        return max;
    }
    
    public int maxArea2(int[] height) {
        //双指针
        int len = height.length;
        if(len<=1){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        int max = 0;
        int left = 0;
        int right = len-1;
        while(left<=right){
            int temp = 0;
            if(height[left]<=height[right]){
                temp = height[left]*(right-left);
                left++;
            }else{
                temp = height[right]*(right-left);
                right--;
            }
            max = temp>max?temp:max;
        }
        return max;
    }
    
}
