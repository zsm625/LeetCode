class Convert {
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        //很神奇的作法
        List<StringBuilder> ss = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ss.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for(char c:s.toCharArray()){
            ss.get(i).append(c);
            if(i==0 || i==numRows-1){
                flag = -flag;
            }
            i +=flag;
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder chars:ss){
            sb.append(chars.toString());
        }
        return sb.toString();
    }
}
