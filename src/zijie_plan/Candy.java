class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //给每个孩子初始化一颗糖
        for(int i=0;i<n;i++){
            right[i]=1;
            left[i]=1;
        }
        //遍历左边
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                left[i] = left[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                right[i] = right[i+1]+1;
            }
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=Math.max(right[i],left[i]);
        }
        //奇思妙想的解法
        // 遍历左边，对于左边而言所有孩子应得糖果数，
        //遍历右边，对于右边而已所有孩子应得糖果数，
        //比较最终左右两边每个孩子应得的最大糖果数总和即为应发糖果最少数
        
        return sum;
    }
}
