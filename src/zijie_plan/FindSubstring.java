class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        //滑动窗口 把每个窗口里的字符与word匹配
        //1、确定窗口大小，同时将words放入map
        Map<String,Integer> wMap = new HashMap<>();
        int wordLen = words.length;
        int sLen = s.length();
        int winLen = words[0].length()*wordLen;
        int woLen = words[0].length();
        for(int i=0;i<wordLen;i++){
            if(wMap.containsKey(words[i])){
                wMap.put(words[i],wMap.get(words[i])+1);
            }else{
                wMap.put(words[i],1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int j=0;j+winLen<=sLen;j++){
            String tempS= s.substring(j,j+winLen);
            Map<String,Integer> tWM = new HashMap<>(wMap);
            int i=0;
            while(i+woLen<=tempS.length()){
                String ss = tempS.substring(i,i+woLen);
                if(tWM.containsKey(ss)){
                    tWM.put(ss,tWM.get(ss)-1);
                    if(tWM.get(ss)==0){
                        tWM.remove(ss);
                    }
                }
                i=i+woLen;
            }
            if(tWM.isEmpty()){
                res.add(j);
            }

        }
        return res;
    }

   
}
