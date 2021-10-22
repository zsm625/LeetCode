class day_10_22 {
    public int divide(int a, int b) {
        //减法超时 放弃
        if(a==0){
            return 0;
        }
        int flag = (a>0&&b<0)||(a<0&&b>0)?-1:1;
        int res = 0;
        long first = (long)a;
        long end = (long)b;
        if(first==Integer.MIN_VALUE && end==-1){
            return Integer.MAX_VALUE;
        }
        if(a>0){
          first=-first;  
        }
        if(b>0){
            end = -end;
        }
        while(first<=end){
            long value = end;
            int k = 1;
            while(value>=0xc0000000 && first<=value+value){
                value+=value;
                k+=k;
            }
            first-=value;
            res+=k;
        }
        return flag>0?res:-res;
    }
}
