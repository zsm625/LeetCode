class MinWindow {
    public String minWindow(String s, String t) {
        //滑动窗口 
        //首先收集需要的字符数量
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> windows = new HashMap<>();
        char[] needs = t.toCharArray();
        for(char ch:needs){
            if(need.containsKey(ch)){
                int count = need.get(ch);
                need.put(ch,count+1);
            }else{
                need.put(ch,1);
            }
        }
        //构建窗口初始化下标
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        int end =s.length();
        char[] chars = s.toCharArray();
        while(right<s.length()){
            char rightVal = chars[right];
            //右移窗口
            right++;
            if(need.containsKey(rightVal)){
                if(windows.containsKey(rightVal)){
                    int c = windows.get(rightVal);
                    windows.put(rightVal,c+1);
                }else{
                    windows.put(rightVal,1);
                }
                if(windows.get(rightVal).equals(need.get(rightVal))){
                    valid++;
                }
            }
            
            //左移窗口
            while(valid==need.size() && left<right){
                //更新最小覆盖子串
                if(right-left<len){
                    start = left;
                    len = right-left;
                    end = right;
                }
                
                char leftVal = chars[left];
                left++;
                //左移窗口后需要做的更新
                if(need.containsKey(leftVal)){
                    //将窗口中的内容减一
                    int jj = windows.get(leftVal);
                    if(windows.get(leftVal).equals(need.get(leftVal))){
                        valid--;
                    }
                    windows.put(leftVal,jj-1);
                }
            }
        }
        return len == Integer.MAX_VALUE?"" : s.substring(start,end);
    }
}
