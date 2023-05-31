class MaxArea {
    public int maxArea(int[] height) {
        // 暴力遍历 超长用例超时
        int maxVolum = 0;
        int hLen = height.length;
        for(int i=0;i<hLen;i++){
            int left = height[i];
            for(int j = i+1;j<hLen;j++){
                int right = height[j];
                int volum = 0;
                if(left<=right){
                    volum = left*(j-i);
                }else{
                    volum = right*(j-i);
                }
                maxVolum = Math.max(volum,maxVolum);
            }
        }
        return maxVolum;
    }
    public int maxArea2(int[] height) {
        // 暴力遍历 超长用例超时
        int maxVolum = 0;
        int hLen = height.length;
        //双指针，左右指针分别置于左右终端，
        //左右移动时，减少间隔，面积-1，
        //长板移动，下一个面积不变或者减少，短板移动，下一个面积可能不变或者增大，因此每次移动短板
        int left = 0,right = hLen-1;
        while(left<right){
            int minHei = Math.min(height[left],height[right]);
            int volum = minHei*(right-left);
            maxVolum = Math.max(volum,maxVolum);
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxVolum;
    }
}
