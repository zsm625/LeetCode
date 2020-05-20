package office66;

/**
 * 车的可用捕获量
 * 
 * @author ZSM
 *
 * @time 2020年3月26日下午4:40:00
 */
public class NumRookCaptures {

	/**
	 * 题目比较简单，思路：
	 * 1、先找到车的位置，
	 * 2、然后上下左右进行遍历，遇到卒就res+1， break，
	 * 3、或者遇到边界以及象也break
	 * 
	 * 车是白色的R（白为大写）
	 * 卒是黑色p（黑为小写）
	 * 象是白色的B
	 * 题目指明只有一个车
	 *@author ZSM
	 * @param board
	 * @return
	 */
	public int numRookCaptures(char[][] board) {
		if(board==null || board.length==0) {
			return 0;
		}
		//先找到车的位置
		int x=-1,y=-1;
		int res=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(board[i][j]=='R') {
					x=i;
					y=j;
					break;
				}
			}
		}
		if(x<0 || y<0) {
			return 0;
		}
		//往上下左右进行遍历
		//上
		for(int i=x;i>=0;i--) {
			if(board[i][y]=='p') {
				res++;
				break;
			}
			if(board[i][y]=='B') {
				break;
			}
		}
		//下
		for(int i=x;i<8;i++) {
			if(board[i][y]=='p') {
				res++;
				break;
			}
			if(board[i][y]=='B') {
				break;
			}
		}
		//左
		for(int i=y;i>=0;i--) {
			if(board[x][i]=='p') {
				res++;
				break;
			}
			if(board[x][i]=='B') {
				break;
			}
		}
		//右
		for(int i=y;i<8;i++) {
			if(board[x][i]=='p') {
				res++;
				break;
			}
			if(board[x][i]=='B') {
				break;
			}
		}
		
		return res;
	}
}
