class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //判断的三个条件 1、每列数字只能出现一次
        //2、每行数字只能出现一次
        //3、每个3x3宫格内只能出现一次
        int[][] colum = new int[9][10];
        int[][] row = new int[9][10];
        int[][] cell = new int[9][10];
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }
               int curNum = board[i][j] - '0';
               //每列
               if(colum[i][curNum] == 1){
                   return false;
               }
               //每行
               if(row[j][curNum] == 1){
                   return false;
               }
               if(cell[j/3+(i/3)*3][curNum] == 1){
                   return false;
               }
               colum[i][curNum] = 1;
               row[j][curNum] = 1;
               cell[j/3+(i/3)*3][curNum] = 1;
            }
        }
        return true;
    }
}
