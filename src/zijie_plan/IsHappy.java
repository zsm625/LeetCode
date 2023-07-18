class IsHappy {
    public boolean isHappy(int n) {
        //进入无限循环，说明是一个环
        int slow = n;
        int fast = squareSum(n);
        while(slow!=fast){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return slow==1;
    }

    public int squareSum(int n){
        int sum = 0;
        while(n>0){
            int remainder = n%10;
            sum += remainder*remainder;
            n = n/10;
        }
        return sum;
    }
}
