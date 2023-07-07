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
}
