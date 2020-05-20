package office66;

/**
 * 
 * @author ZSM
 *
 * @time 2020年4月15日下午1:42:10
 */
public class MyAtoi {
	/**
	 * 先把数字扣下来，用正则表达式"^(\-)?d+$"
	 *@author ZSM
	 * @param str
	 * @return 
	 */
	public int myAtoi(String str) {
		char[] chars = str.toCharArray();
		int n = chars.length;
		int indx=0;
		while(indx<n && chars[indx]==' ') {
			indx++;
		}
		if(indx==n) {
			return 0;
		}
		boolean negative = false;
		if(chars[indx]=='-') {
			negative = true;
			indx++;
		}else if(chars[indx]=='+') {
			indx++;
		}else if(!Character.isDigit(chars[indx])) {
			return 0;
		}
		int ans = 0;
		while(indx<n && Character.isDigit(chars[indx])) {
			int digit = chars[indx]-'0';
			if(ans>(Integer.MAX_VALUE-digit)/10) {
				return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
			}
			ans=ans*10+digit;
			indx++;
		}
		return negative?-ans:ans;
		
	}
	public static void main(String[] args) {
		MyAtoi atoi = new MyAtoi();
		atoi.myAtoi("43 wa");
	}
	

}
