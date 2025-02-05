class MaxArea {
    public int maxArea(int[] height) {
        // 双指针,找大的的算面积
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<height.length-1 && left < right){
             int length= Math.min(height[left],height[right]);
                int wide = right-left;
                int area = length*wide;
                maxArea = Math.max(area,maxArea);
                if(height[left]<=height[right]){
                    left++;
                }else{
                    right--;
                }
            
        }
        return maxArea;

    }


    private int maxArea1(int[] height) {
        // 双指针,一个一个矩形遍历过去 离谱超时
        int left = 0;
        int maxArea = 0;
        while(left<height.length-1){
             int right = left+1;
            while(right<height.length){
                int length= Math.min(height[left],height[right]);
                int wide = right-left;
                int area = length*wide;
                maxArea = Math.max(area,maxArea);
                right++;
            }
            left++;
        }
        return maxArea;

    }
}
