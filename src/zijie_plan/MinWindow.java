class MinWindow {
  //超时
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        String result = s+t;
        Map<Character,Integer> charCount = new HashMap<>();
        for(int i=0;i<tLen;i++){
            charCount.put(t.charAt(i),charCount.getOrDefault(t.charAt(i),0)+1);
        }
        for(int i=0;i<sLen;i++){
            if(charCount.containsKey(s.charAt(i))){
                int end = i;
                Map<Character,Integer> tempMap = new HashMap<>(charCount);
                while(end<sLen){
                    if(tempMap.containsKey(s.charAt(end))){
                        tempMap.put(s.charAt(end),tempMap.get(s.charAt(end))-1);
                        if(tempMap.get(s.charAt(end))==0){
                            tempMap.remove(s.charAt(end));
                        }
                    }
                    if(tempMap.isEmpty()){
                        int distance = end-i;
                        if(distance<result.length()){
                            result = s.substring(i,end+1);
                        }
                        break;
                    }
                    end++;
                }
            }
        }
        return result.equals(s+t)?"":result;

    }
}
