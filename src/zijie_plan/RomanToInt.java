class RomanToInt {
    public int romanToInt(String s) {
        int num = 0;
        int len = s.length();
        if(len==1){
            return getValue(s.charAt(0));
        }
        int result = 0;
        for(int i=1;i<len;i++){
            int cur = getValue(s.charAt(i));
            int preNum = getValue(s.charAt(i-1));
            if(preNum<cur){
                result-=preNum;
            }else{
                result+=preNum;
            }
            if(i==len-1){
                result+=cur;
            }
        }
        return result;
        
    }

    public Integer getValue(char ch){
        int result = 0;
        switch(ch){
            case 'I' : result = 1;
            break;
            case 'V' : result = 5;
            break;
            case 'X' : result = 10;
            break;
            case 'L' : result = 50;
            break;
            case 'C' : result = 100;
            break;
            case 'D' : result = 500;
            break;
            case 'M' : result = 1000;
            break;
        }
        return result;

    }
}
