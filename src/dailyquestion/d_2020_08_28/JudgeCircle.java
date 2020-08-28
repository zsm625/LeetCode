package dailyquestion.d_2020_08_28;

/**
 * 机器人回到原点
 * @author zsm
 *
 *     时间：2020年8月28日
 */
public class JudgeCircle {
	
	/**
	 * 上下左右移动，将原点作为（0,0）
	 * U ：y+1； R ：x++；
	 * D ：y-1； L ：x--；
	 * 最后如果x=0，y=0，则回到原点
	 * @param s
	 * @return
	 */
	public boolean judgeCircle(String s) {
		if(s.length()%2!=0) {
			return false;
		}
		int x=0,y=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='U') {
				y++;
			}
			if(s.charAt(i)=='D') {
				y--;
			}
			if(s.charAt(i)=='R') {
				x++;
			}
			if(s.charAt(i)=='L') {
				x--;
			}
		}
		
		return x==0&&y==0;
		
	}

}
