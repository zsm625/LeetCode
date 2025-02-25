class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> ans = new ArrayList();
        if(pLen>sLen){
            return new ArrayList<>();
        }
        for(int i=0;i<pLen;i++){
            ++sCount[s.charAt(i)-'a'];
            ++pCount[p.charAt(i)-'a'];
        }
        if(Arrays.equals(sCount,pCount)){
            ans.add(0);
        }
        for(int i=0;i<sLen-pLen;i++){
            --sCount[s.charAt(i)-'a'];
            ++sCount[s.charAt(i+pLen)-'a'];
            if(Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
