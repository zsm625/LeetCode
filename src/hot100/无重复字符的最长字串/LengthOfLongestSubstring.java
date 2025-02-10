class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //
        int left = 0;
        int right = 1;
        int length = s.length();
        if(length<=1){
            return length;
        }
        char[] chars = s.toCharArray();
        int maxLen = 0;
        while(right<length){
            int tempIndex = right;
            char c = chars[right];
            boolean flag = false;
            while(tempIndex>left){
                if(c==chars[--tempIndex]){
                    left = tempIndex+1;
                    break;
                }
            }
            int len = right-left+1;
            maxLen = Math.max(maxLen,len);
            right++;
        }
        return maxLen;
    }
}
