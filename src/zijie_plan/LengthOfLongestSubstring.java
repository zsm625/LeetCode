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
    
    //滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        int start=0;
        int len = s.length();
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            if(map.containsKey(s.charAt(i))){
                start = Math.max(map.get(s.charAt(i))+1,start);
            }
            map.put(s.charAt(i),i);
            ans = Math.max(i-start+1,ans);
        }
        return ans;

    }
}
