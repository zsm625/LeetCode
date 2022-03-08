class SolveNQueens {
    private List<List<String>> res= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        backtrace(board,0);
        return res;
    }
    
    public void backtrace(char[][] board,int row){
        int len = board.length;
        //结束
        if(row==len){
            res.add(toList(board));
            return;
        }
        int n = board[row].length;
        //做选择
        for(int i=0;i<n;i++){
            //判断是否有效
            if(!isValid(board,row,i)){
                continue;
            }
            //选择
            board[row][i] = 'Q';
            backtrace(board,row+1);
            //撤销选择
            board[row][i]='.';
        }
    }
    
    //
    public boolean isValid(char[][] board,int row,int col){
        int len = board.length;
        
        //判断列表是否有皇后
        for(int j=0;j<len;j++){
            if(board[j][col]=='Q'){
                return false;
            }
        }
        
        //左上和右上
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        
        for(int i=row-1,j=col+1;i>=0&&j<len;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    
    public List<String> toList(char[][] board){
        List<String> res = new ArrayList<>();
        for(char[] c:board){
            res.add(String.copyValueOf(c));
        }
        return res;
    }
}
