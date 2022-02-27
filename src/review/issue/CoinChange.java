class CoinChange {
    int[] memo ;
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0){
            return -1;
        }
        memo = new int[amount+1];
        Arrays.fill(memo,-666);
        return dp(coins,amount);
    }
    
    public int dp(int[] coins,int amount){
        //终结条件
        if(amount==0) return 0;
        if(amount<0) return -1;
        int res = Integer.MAX_VALUE;
        if(memo[amount]!=-666){
            return memo[amount];
        }
        for(int c:coins){
            int sub = dp(coins,amount-c);
            if(sub==-1){
                continue;
            }
            res = Math.min(res,sub+1);
           
        }
        memo[amount] = res==Integer.MAX_VALUE?-1:res;
        return memo[amount];
    }
}
