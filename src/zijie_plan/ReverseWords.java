class ReverseWords {
    public String reverseWords(String s) {
		s = trimSpace(s);
		int left = 0,right=0;
		StringBuilder sb = new StringBuilder(s);
		while(right<s.length()){
			if(s.charAt(right)==' '){
				//反转单词
				reverse(sb,left,right-1);
				left=right+1;
			}else if(right==s.length()-1){
				reverse(sb,left,right);
			}
			right++;
		}

		return sb.toString();
	}
	public String trimSpace(String s){
		StringBuilder str = new StringBuilder();
		char[] chars = s.toCharArray();
		int left = 0,right = s.length()-1;
		//去除头部空格
		while(left<=right && s.charAt(left)==' '){
			left++;
		}
		//去除尾部空格
		while(left<=right && s.charAt(right)==' '){
			right--;
		}
		//去除中间的空格 顺便反转字符串
		int trimIndex = 0;
		while(left<=right){
			if(s.charAt(right)!=' '){
				str.append(s.charAt(right));
				trimIndex=0;
			}else if(s.charAt(right)==' '){
				trimIndex++;
				if(trimIndex==1){
					str.append(' ');
				}
			}
			right--;
		}
		return str.toString();
	}
	public void reverse(StringBuilder s,int left,int right){
		for(;left<=right;left++,right--){
			char temp = s.charAt(left);
			s.setCharAt(left,s.charAt(right));
			s.setCharAt(right,temp);
		}
	}
}
