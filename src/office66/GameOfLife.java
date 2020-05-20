package office66;

/**
 * 细胞生存游戏
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * @author ZSM
 *
 * @time 2020年4月2日上午11:37:52
 */
public class GameOfLife {

	/**
	 * 时间复杂度为O(mn)
	 * 空间复杂度为O(mn)
	 *@author ZSM
	 * @param board
	 */
	public void gameOfLife(int[][] board) {
		if(board==null || board.length==0) {
			return ;
		}
		int[][] res = new int[board.length][board[0].length];
		
		//将board数组复制到res数组中
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				res[i][j]=board[i][j];
			}
		}
		int[] neighbor = {0,1,-1};
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++) {
				int liveLife = 0;
				//对当前格子的八个隔壁格子进行遍历
				for(int r = 0;r<3;r++) {
					for(int c = 0;c<3;c++) {
						if(!(neighbor[r]==0 && neighbor[c]==0)) {
							int row = i+neighbor[r];
							int col = j+neighbor[c];
							if((row>=0 && row<res.length )&& (col>=0 && col<res[i].length) && res[row][col]==1 ) {
								liveLife++;
							}
						}
					}
				}
				//几种情况有
				if(res[i][j]==1 && (liveLife <2 || liveLife>3)) {
					board[i][j] = 0;
				}
				if(res[i][j]==0 && (liveLife==3)) {
					board[i][j]=1;
				}
				
			}
		}
	}
	
	//试试用复合状态的,尝试将空间复杂度转为O(1)
	public void gameOfLife2(int[][] board) {
		if(board==null || board.length==0) {
			return;
		}
		int[] neighbor= {0,1,-1};
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board[row].length;col++) {
				//遍历周围的八个格子
//				if(board[row][col]==1) {
					for(int i=0;i<3;i++) {
						for(int j=0;j<3;j++) {
							if(!(neighbor[i]==0 && neighbor[j]==0)) {
								int r = row+neighbor[i];
								int c = col+neighbor[j];
								if((r>=0 && r<board.length )&& (c>=0 && c<board[row].length) && board[r][c]%10==1) {
									//保证原来的
									board[row][col]+=10;
								}
							}
						}
					}
//				}
					
			}
			
		}
		//最后整理得到的结果
		for(int r=0;r<board.length;r++) {
			for(int c=0;c<board[r].length;c++) {
//				board[r][c]/10
				if(board[r][c]%10==1 ) {
					if(board[r][c]/10<2 || board[r][c]/10>3) {
						board[r][c]=0;
					}else {
						board[r][c]=1;
					}
					
				}
				if(board[r][c]%10==0) {
					if(board[r][c]/10==3) {
						board[r][c]=1;
					}else {
						board[r][c]=0;						
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		GameOfLife life = new GameOfLife();
		int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		life.gameOfLife2(board);
	}
}
