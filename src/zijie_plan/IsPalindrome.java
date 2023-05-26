class IsPalindrome {
    public boolean isPalindrome(String s) {
        //简单粗暴第一步，先把所有字母字符捞出来
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = getAlphabet(s.charAt(i));
            if(c!=' '){
                sb.append(c);
            }
        }
        String words = sb.toString();
        int left = 0,right = words.length()-1;
        while(left<=right){
            if(words.charAt(left)!=words.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public char getAlphabet(char c){
       if(c>='a' && c<='z'){
            return c;
        }
        if(c>='0' && c<='9'){
            return c;
        }
       return ' ';
    }
}
