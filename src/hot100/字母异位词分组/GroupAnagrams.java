class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        //1、将所有字符转ascII码
        return groupAnagrams1(strs);

    }

    public List<List<String>> groupAnagrams1(String[] strs){
        if(strs.length==0){
            return new ArrayList<>();
        }
        Map<String,List<String>> strCharSumMap = new HashMap<>();
        for(String str:strs){
            String ss = recombine(str);
            if(strCharSumMap.containsKey(ss)){
                List<String> list = strCharSumMap.get(ss);
                list.add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                strCharSumMap.put(ss,list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        strCharSumMap.keySet().forEach(key->{
            List<String> list = strCharSumMap.get(key);
            res.add(list);
        });
        return res;

    }

    //重组字符
    private String recombine(String str){
        if(str.length()==0){
            return null;
        }
        int[] counter = new int[26];
        char[] chars = str.toCharArray();
        for(char c:chars){
           counter[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if(counter[i]>=1){
                sb.append(counter[i]);
                sb.append(i+'a');
            }
        }

        return sb.toString();
    }
}
