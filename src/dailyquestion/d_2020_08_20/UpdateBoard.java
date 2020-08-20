package dailyquestion.d_2020_08_20;

/**
 * 扫雷游戏
 * 让我们一起来玩扫雷游戏！
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。如果在此次点击中，若无更多方块可被揭露，则返回面板。
 * @author ZSM
 *
 * @time 2020年8月20日上午8:14:10
 */
public class UpdateBoard {
	/**
	 * 总共有三种情况：
	 * 1、点击到雷，将雷改为X，返回board
	 * 2、点击到空白处且没有地雷，将他改为B，再依次点击周围空白处
	 * 3、点击到空白，周围有地雷，返回地雷个数
	 *@author ZSM
	 * @param board
	 * @param click
	 * @return
	 */
	public char[][] updateBoard(char[][] board,int[] click){
		int x = click[0],y=click[1];
		if(board[x][y]=='M') {
			board[x][y] = 'X';
		}else {
			dfs(board,x,y);
		}
		return board;
	}
	
	public void dfs(char[][] board,int x,int y) {
		int count = check(board,x,y);
		if(count==0) {
			board[x][y] = 'B';
			//up
			if(x>0 && board[x-1][y]=='E') dfs(board,x-1,y);
			//up left
			if(x>0 && y>0 && board[x-1][y-1]=='E') dfs(board,x-1,y-1);
			//up right
			if(x>0 && y<board[0].length-1 && board[x-1][y+1]=='E') dfs(board,x-1,y+1);
			//left
			if(y>0 && board[x][y-1]=='E') dfs(board,x,y-1);
			//right
			if(y<board[0].length-1 && board[x][y+1]=='E') dfs(board,x,y+1);
			//down 
			if(x<board.length-1 && board[x+1][y]=='E') dfs(board,x+1,y);
			//down left
			if(x<board.length-1 && y>0 &&board[x+1][y-1]=='E') dfs(board,x+1,y-1);
			if(x<board.length-1 && y<board[0].length-1 && board[x+1][y+1]=='E') dfs(board,x+1,y+1);
			
		}else {
			board[x][y]=(char)('0'+count);
		}
	}
	
	/**
	 * 检查当前点击的空白周围的地雷数
	 *@author ZSM
	 * @param board
	 * @param x
	 * @param y
	 * @return
	 */
	public int check(char[][] board,int x,int y) {
		int count = 0;
		//up
		if(x>0 && board[x-1][y]=='M') count++;
		//up left
		if(x>0 && y>0 && board[x-1][y-1]=='M') count++;
		//up right
		if(x>0 && y<board[0].length-1 && board[x-1][y+1]=='M') count++;
		//left
		if(y>0 && board[x][y-1]=='M') count++;
		//right
		if(y<board[0].length-1 && board[x][y+1]=='M') count++;
		//down 
		if(x<board.length-1 && board[x+1][y]=='M') count++;
		//down left
		if(x<board.length-1 && y>0 &&board[x+1][y-1]=='M') count++;
		if(x<board.length-1 && y<board[0].length-1 && board[x+1][y+1]=='M') count++;
		
		return count;
		
	}
	
	public static void main(String[] args) {
		UpdateBoard upB = new UpdateBoard();
		char[][] board= {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
		char[][] cs = upB.updateBoard(board, new int[]{3,0});
		for (char[] c : cs) {
			for(int i=0;i<c.length;i++) {
				System.out.print(c[i]+"\t");
			}
			System.out.println();
		}
	}
}
