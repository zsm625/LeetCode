class MajorityElement {
    public int majorityElement(int[] nums) {
    // 寻找众数
        int count = 0;
        Integer can = null;
        for(int n:nums){
            if(count == 0){
                can = n;
            }
            count +=(can == n)?1:-1;
        }
        return can;
    }
}
