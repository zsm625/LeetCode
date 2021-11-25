class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        if(len<=1){
            return 0;
        }
        int res = 0;
        int max = values[0]+0;
        for(int i=1;i<len;i++){
            int temp = values[i]-i;
            res = Math.max(res,max+temp);
            max = Math.max(max,values[i]+i);
        }
        return  res;
    }
}
