package dailyquestion.d_2020_09_15;

import java.util.ArrayList;
import java.util.List;

/**
 * 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。
 * @author zsm
 *
 *     时间：2020年9月15日
 */
public class SolveSudoku {

	//行
	private boolean[][] line = new boolean[9][9];
	//列
	private boolean[][] column = new boolean[9][9];
	//小九宫格
	private boolean[][][] block = new boolean[9][9][9];
	private boolean valid = false;
	private List<int[]> spaces = new ArrayList<>();
	/**
	 * 递归
	 * @param board
	 */
	public void solveSudoku(char[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j = 0;j<board[i].length;j++) {
				if(board[i][j]=='.') {
					spaces.add(new int[]{i,j});
				}else {
					int digit = board[i][j]-'0'-1;
					line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
				}
			}
		}
		dfs(board,0);
	}
	
	public void dfs(char[][] board,int pos) {
		if(pos==spaces.size()) {
			this.valid = true;
			return;
		}
		int [] space = spaces.get(pos);
		int i=space[0],j=space[1];
		for(int digit=0;digit<9&&!valid;digit++) {
			if(!line[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]) {
				line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
				board[i][j] = (char)(digit+'0'+1);
				dfs(board,pos+1);
				line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = false;
			}
		}
	}
}
