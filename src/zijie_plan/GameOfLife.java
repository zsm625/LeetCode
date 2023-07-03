class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n= board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // 用活细胞影响八个位置的细胞
                //如果是活细胞，那么给八个位置上都加上10
                //通过自身数值来判断活细胞数
                int liveNum = liveNum(board,i,j);
                board[i][j] += liveNum*10;
            }
        }

        //复盘活细胞数
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live = board[i][j]/10;
                int isLive = board[i][j]%10;
                //细胞活的资格：2个或者3个活细胞，细胞存活 超过3个细胞死亡
                if(isLive==0 && live==3){
                    board[i][j] = 1;
                    continue;
                }
                if(live>3 || live<2){
                    board[i][j]=0;
                    continue;
                }
                board[i][j]=isLive;
            }
        }    
    }

    public int liveNum(int[][] board,int row,int col){
        //判断前后两行的活细胞数
        int m=board.length;
        int n= board[0].length;
        int num = 0;
        for(int i=row-1;i<row+2;i++){
            if(i<0 || i>=m){
                continue;
            }
            for(int j=col-1;j<col+2;j++){
                if(j<0 || j>=n){
                    continue;
                }
                if(i==row && j==col){
                    continue;
                }
                num+=(board[i][j]%10);
                
            }
        }
        return num;
    }
}
