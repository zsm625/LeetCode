class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int tLen= t.length();
        int sLen = s.length();
        if(tLen!=sLen){
            return false;
        }
        Map<Character,Character> tMap = new HashMap<>();
        Map<Character,Character> sMap = new HashMap<>();
        for(int i=0;i<sLen;i++){
            char tc = t.charAt(i);
            char sc = s.charAt(i);
            if(tMap.containsKey(tc) && tMap.get(tc)!=sc 
            || sMap.containsKey(sc) && sMap.get(sc)!=tc){
               return false;
            }
            tMap.put(tc,sc);
            sMap.put(sc,tc);
        }
        return true;
    }
}
