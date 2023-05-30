class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int nLen = numbers.length;
        // 如果可以使用额外空间，可以用map，时间复杂度为O(n)
        //暴力遍历
        for(int i=0;i<nLen;i++){
            int next = target-numbers[i];
            for(int j=i+1;j<nLen;j++){
                if(next==numbers[j]){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
