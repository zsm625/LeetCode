class StrStr {
    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        if(hlen == nlen){
            return haystack.equals(needle)?0:-1;
        }
        for(int i=0;i<=hlen-nlen;i++){
            int right = i;
            int j=0;
            boolean flag = true;
            while(j<nlen && flag && right<hlen){
                if(haystack.charAt(right) != needle.charAt(j)){
                    flag = false;
                }
                j++;
                right++;
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}
