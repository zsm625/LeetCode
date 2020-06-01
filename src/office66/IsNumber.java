package office66;

/**
 * 判断是否为数字
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 * @author ZSM
 *
 * @time 2020年6月1日上午11:01:22
 */
public class IsNumber {

	public boolean isNumber(String s) {
		if(s==null || s.length()==0) {
			return false;
		}
		//标记是否遇到相应的情况
		boolean numSeen = false;
		boolean dotSeen = false;
		boolean eSeen = false;
		char[] str = s.trim().toCharArray();
		for(int i=0;i<str.length;i++) {
			//先判断是不是数字
			if(str[i]>='0' && str[i]<='9') {
				numSeen = true;
			}else if(str[i]=='.') {
				if(dotSeen||eSeen) {
					return false;
				}
				dotSeen = true;
			}else if(str[i]=='e' || str[i]=='E') {
				if(eSeen || !numSeen) {
					return false;
				}
				eSeen = true;
				numSeen = false;
			}else if(str[i]=='-'||str[i]=='+') {
				if(i!=0 && str[i-1]!='e'&&str[i]!='E') {
					return false;
				}
			}else {
				return false;
			}
		}
		return numSeen;
	}
}
