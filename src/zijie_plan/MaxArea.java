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
}
