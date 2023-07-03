class CanConstruct2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();
        int mLen = magazine.length();
        int rLen = ransomNote.length();
        for(int i=0;i<mLen;i++){
            if(charMap.containsKey(magazine.charAt(i))){
                charMap.put(magazine.charAt(i),charMap.get(magazine.charAt(i))+1);
            }else{
                charMap.put(magazine.charAt(i),1);
            }
        }

        for(int j=0;j<rLen;j++){
            char t = ransomNote.charAt(j);
            if(!charMap.containsKey(t)){
                return false;
            }else{
                charMap.put(t,charMap.get(t)-1);
            }
            if(charMap.get(t)<0){
                return false;
            }
        }
        return true;
    }
}
