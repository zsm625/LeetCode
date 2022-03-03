class CalculateMinimumHP {
    /* 主函数 */
private int[][] memo ;
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        memo = new int[m][n];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dp(dungeon,0,0);
    }
    
    //明确dp函数 计算最小生命值
    public int dp(int[][] grid,int i,int j){
        //状态变化 数组下标，生命值
        int m = grid.length;
        int n = grid[0].length;
         //base case  当到达最右下时 grid[n-1][m-1] >=0 ? 1: -grid[n-1][m-1]+1
        if(i==m-1 && j==n-1){
            return grid[i][j]>=0? 1 : -grid[i][j]+1;
        }
        
        if(i==m || j==n){
            return Integer.MAX_VALUE;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        //选择 往右和 往下 grid[i][j+1] grid[i+1][j]
        int res = Math.min(dp(grid,i,j+1),dp(grid,i+1,j))-grid[i][j];
        memo[i][j] = res<=0 ? 1 : res;
        return memo[i][j];
    }

}
