class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int start=0,end = 0;
        int len = s.length();
        int ans = 0;
        while(end<len){
            int k = end;
            boolean flag = true;
            while(k>=1 && k>start){
                if(s.charAt(end)==s.charAt(k-1)){
                    flag = false;
                    start = k;
                    break;
                }
                k--;
            }
            if(flag){
                ans=Math.max(ans,end-start+1);
            }
            end++;
        }
        return ans;

    }
}
