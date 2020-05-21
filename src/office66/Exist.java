package office66;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，
 * 那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * @author ZSM
 *
 * @time 2020年5月21日上午9:47:20
 */
public class Exist {

	/**
	 * 深度优先遍历+剪枝
	 * 
	 * 假设字符长度为K
	 * 时间复杂度O(3^kMN)
	 * 最差的情况下，需要遍历矩阵中所有长度为K字符串的所有方案，时间复杂度O(3^k)
	 * 矩阵中共有MN个起点，时间复杂度为O(MN)
	 * 空间复杂度为O(K)
	 *@author ZSM
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board,String word) {
		if(board==null || board.length==0 || board[0].length==0 || word==null || word.length()==0) {
			return false;
		}
		char[] chars = word.toCharArray();
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(dfs(board,chars,i,j,0)) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	private boolean dfs(char[][] board,char[] chars,int i,int j,int index_ch) {
		if(i>=board.length || i<0 || j>=board[0].length||j<0 || board[i][j]!=chars[index_ch]) {
			return false;
		}
		if(index_ch==chars.length-1) {
			return true;
		}
		char tmp = board[i][j];
		board[i][j] = '/';
		boolean res = dfs(board,chars,i+1,j,index_ch+1) || dfs(board,chars,i-1,j,index_ch+1)
				|| dfs(board,chars,i,j+1,index_ch+1)||dfs(board,chars,i,j-1,index_ch+1);
		board[i][j] = tmp;
		return res;
	}
	
}
