class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //1 暴力遍历解决 最后两个用例通不过，超时。。。
        int gasLen = gas.length;
        int costLen = cost.length;
        for(int i=0;i<gasLen;i++){
            if(gas[i]==0){
                continue;
            }
            int sumGas = 0;
            int sumCost = 0;
            int k=i;
            while(k<gasLen){
                sumGas+=gas[k];
                sumCost+=cost[k];
                if(sumGas<sumCost){
                    break;
                }
                k = (k+1)%gasLen;
                if(k==i){
                    return i;
                }
                
            }
        }
        return -1;
    }
    
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int gasLen = gas.length;
        // 2 总油量>=总耗油量 不符合条件的直接pass 
        int totalGas = 0;
        int curGas = 0;
        int res = 0;
        for(int i=0;i<gasLen;i++){
            totalGas += gas[i]-cost[i];
            curGas += gas[i]-cost[i];
            if(curGas<0){
                res = (i+1)%gasLen;
                curGas = 0;
            }
        }
        if(totalGas<0){
            return -1;
        }
        return res;
    }
}
