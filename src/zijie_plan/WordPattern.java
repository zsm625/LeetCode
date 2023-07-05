class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        int pLen = pattern.length();
        String[] words = s.split(" ");
        int wLen = words.length;
        if(pLen!=wLen){
            return false;
        }
        Map<Character,String> pMap = new HashMap<>();
        Map<String,Character> sMap = new HashMap<>();
        for(int i=0;i<pLen;i++){
            char pp = pattern.charAt(i);
            String ss = words[i];
            if(pMap.containsKey(pp) && !pMap.get(pp).equals(ss)
            || sMap.containsKey(ss) && sMap.get(ss)!=pp){
                return false;
            }
            pMap.put(pp,ss);
            sMap.put(ss,pp);
        }
        return true;
    }
}
