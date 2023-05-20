class IntToRoman {
    public String intToRoman(int num) {
        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<values.length;i++){
            int val = values[i];
            while(num>=val){
                num-=val;
                sb.append(symbol[i]);
            }
            if(num==0){
                break;
            }
        }
        return sb.toString();
    }
}
