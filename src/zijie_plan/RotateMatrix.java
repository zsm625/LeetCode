class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //对角线翻转
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //从右至左反转
        int k = n/2;
        for(int i=0;i<k;i++){
            for(int j=0;j<n;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}
