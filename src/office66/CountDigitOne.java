package office66;

/**
 * 1-n整数中1出现的次数
 * @author ZSM
 *
 * @time 2020年7月27日上午9:17:29
 */
public class CountDigitOne {

	/**
	 * 
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int countDigitOne(int n) {
		int digit=1,res=0;
		int hight = n/10,cur=n%10,low=0;
		while(hight!=0||cur!=0) {
			if(cur==0) {
				res += hight*digit;
			}else if(cur==1) {
				res+=hight*digit+low+1;
			}else {
				res+=(hight+1)*digit;
			}
			low+=cur*digit;
			cur=hight%10;
			hight=hight/10;
			digit*=10;
			
		}
		return res;
	}
}
