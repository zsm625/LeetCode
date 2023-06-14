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
  public String minWindow2(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        //滑动窗口 
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(int i=0;i<tLen;i++){
            //窗口中应出现的字符
            window.put(t.charAt(i),0);
            //需要覆盖的字符
            if(need.containsKey(t.charAt(i))){
                need.put(t.charAt(i),need.get(t.charAt(i))+1);
            }else{
                need.put(t.charAt(i),1);
            }
        }
        int left = 0;
        int right = 0;
        int needStrLen = 0;
        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        while(right<sLen){
             char cur = s.charAt(right);
             if(need.containsKey(cur)){
                 window.put(cur,window.get(cur)+1);
                 if(window.get(cur).equals(need.get(cur))){
                    needStrLen++;
                 }
             }
             while(needStrLen==need.size()){
                 if(right-left<len){
                     start = left;
                     end = right;
                     len = end-start;
                 }
                 //收缩窗口
                 char leftCur = s.charAt(left);
                 if(need.containsKey(leftCur)){
                     if(window.get(leftCur).equals(need.get(leftCur))){
                         needStrLen--;
                     }
                     window.put(leftCur,window.get(leftCur)-1);
                 }
                 left++;
             }
             right++;
        }

        return len==Integer.MAX_VALUE?"":s.substring(start,end+1);

    }
  
}
