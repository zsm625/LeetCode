class Rotate {
    public void rotate(int[][] matrix) {
        // 先按照对角线将对称的部分翻转
        int len = matrix.length;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //然后反转每一行
        for(int[] nums:matrix){
            reverse(nums);
        }
        
    }
    public void reverse(int[] nums){
        int i=nums.length-1;
        int j=0;
        while(j<i){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i--;
            j++;
        }
    }
}
