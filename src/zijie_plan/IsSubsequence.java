class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // 暴力遍历
        int sLen = s.length();
        int tLen = t.length();
        int j = 0;
        for(int i=0;i<tLen && j<sLen;i++){
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
        }
        if(j==sLen){
            return true;
        }
        return false;
    }
}
