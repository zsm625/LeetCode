class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
       int n = matrix.length;
        int m = matrix[0].length;
        int upperBound = 0;
        int downBound = n-1;
        int leftBound = 0;
        int rightBound = m-1;
        //从左到右 flag =false 进入从上到下
        List<Integer> ans = new ArrayList<>();
        while(ans.size()<m*n){
            //从左到右
            if(upperBound<=downBound){
                for(int i=leftBound;i<=rightBound;i++){
                    ans.add(matrix[upperBound][i]);
                }
                upperBound++;
            }
            //从上到下
            if(leftBound<=rightBound){
                for(int i=upperBound;i<=downBound;i++){
                    ans.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            //从右到左
            if(upperBound<=downBound){
                for(int i=rightBound;i>=leftBound;i--){
                    ans.add(matrix[downBound][i]);
                }
                downBound--;
            }
            //从下到上
            if(leftBound<=rightBound){
                for(int i=downBound;i>=upperBound;i--){
                    ans.add(matrix[i][leftBound]);
                }
                leftBound++;
            }

        }
        return ans;
    }
}
