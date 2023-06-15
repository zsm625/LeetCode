class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        //文本左右对齐有三种情况
        //1、单词位于最后一行，单词末空格填坑
        //2、单词位于中间行，只有一个单词，单词末空格填坑
        //3、单词位于中间行，有多个单词，单词中间空格为 （maxWidth-words.length)/单词个数 
        // 如果（maxWidth-words.length)%单词个数 ！=0 那么前（maxWidth-words.length)%单词个数 的空格数都会格外+1
        int right = 0,len = words.length;
        List<String> ans = new ArrayList<>();
        while(true){
            int left = right;
            int sumLen = 0;
            while(right<len && sumLen+words[right].length()+right-left<=maxWidth){
                sumLen+=words[right++].length();
            }
            //last one
            if(right==len){
                StringBuilder sb = join(words,left,len," ");
                sb.append(blank(maxWidth-sb.length()));
                ans.add(sb.toString());
                return ans;
            }
            int wordsNum = right-left;
            int numSpec = maxWidth-sumLen;
            if(wordsNum==1){
                StringBuilder sb = new StringBuilder(words[left]);
                sb.append(blank(numSpec));
                ans.add(sb.toString());
                continue;
            }

            int avgSpaces = numSpec/(wordsNum-1);
            int extraSpaces = numSpec%(wordsNum-1);
            StringBuffer sb = new StringBuffer();
            sb.append(join(words,left,left+extraSpaces+1,blank(avgSpaces+1)));
            sb.append(blank(avgSpaces));
            sb.append(join(words,left+extraSpaces+1,right,blank(avgSpaces)));
            ans.add(sb.toString());
            
        }
    }

    public String blank(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(" ");
        }
        return sb.toString();
    }
    public StringBuilder join(String[] words,int left,int right,String sep){
        StringBuilder sb = new StringBuilder(words[left]);
        for(int i=left+1;i<right;i++){
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }

    
}
