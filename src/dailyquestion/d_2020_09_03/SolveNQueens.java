package dailyquestion.d_2020_09_03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * N皇后问题
 *   在同一行，同一列，对角线上不能同时存在
 *   经典回溯算法案例
 * @author zsm
 *
 *     时间：2020年9月3日
 */
public class SolveNQueens {
	private int n;
	//记录每一列是否出现皇后
	private boolean[] col;
	//记录对角线是否出现皇后
	private boolean[] main;
	//记录副对角线是否出现皇后
	private boolean[] subMain;
	private List<List<String>> res;
	public List<List<String>> solveQueens(int n){
		this.res = new ArrayList<>();
		if(n==0) {
			return res;
		}
		this.n=n;
		this.col = new boolean[n];
		this.main = new boolean[2*n-1];
		this.subMain = new boolean[2*n-1];
		
		Deque<Integer> path = new ArrayDeque<>();
		dfs(0,path);
		return res;
		
	}

	public void dfs(int row,Deque<Integer> path) {
		if(row==this.n) {
			List<String> board = convertToBoard(path);
			res.add(board);
			return;
		}
		//针对小标为row的每一列，尝试是否可以放置
		for(int i=0;i<n;i++) {
			if(!col[i] && !main[row+i] && !subMain[row-i+n-1]) {
				path.addLast(i);
				col[i] = true;
				main[row+i] = true;
				subMain[row-i+n-1] = true;
				dfs(row+1,path);
				subMain[row-i+n-1] = false;
				main[row+i] = false;
				col[i] = false;
				path.removeLast();
			}
		}
		
	}
	public List<String> convertToBoard(Deque<Integer> path){
		List<String> board = new ArrayList<>();
		for (Integer num : path) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n;i++) {
				sb.append(".");
			}
			sb.replace(num, num+1, "Q");
			board.add(sb.toString());
		}
		return board;
	}
}
