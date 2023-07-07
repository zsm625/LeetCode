class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //给字母排序，突破口
        int strLen = strs.length;
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> wordsMap = new HashMap<>();
        for(String s:strs){
            char[] chas = s.toCharArray();
            Arrays.sort(chas);
            String sortStr = Arrays.toString(chas);
            if(wordsMap.containsKey(sortStr)){
                List<String> list = wordsMap.get(sortStr);
                list.add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                wordsMap.put(sortStr,list);
            }
        }
        if(!wordsMap.isEmpty()){
            Set<String> keys =  wordsMap.keySet();
            for(String key:keys){
                res.add(wordsMap.get(key));
            }
        }
        return res;
        
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        //方法二：将每个字符串中字符出现的个数与字符组成一个新的字符串作为key
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> wordsMap = new HashMap<>();
        for(String s:strs){
            char[] chas = s.toCharArray();
            String countStr = counterStr(chas);
            if(wordsMap.containsKey(countStr)){
                List<String> list = wordsMap.get(countStr);
                list.add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                wordsMap.put(countStr,list);
            }
        }
        if(!wordsMap.isEmpty()){
            Set<String> keys =  wordsMap.keySet();
            for(String key:keys){
                res.add(wordsMap.get(key));
            }
        }
        return res;
        
    }

    public String counterStr(char[] chas){
        char[] counter = new char[26];
        for(int i=0;i<chas.length;i++){
            counter[chas[i]-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<counter.length;i++){
            if(counter[i]>0){
                sb.append((char)'a'+i);
                sb.append(counter[i]);
            }
        }
        return sb.toString();
    }
}
