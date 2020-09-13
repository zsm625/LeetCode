package dailyquestion.d_2020_09_13;

/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * @author zsm
 *
 *     时间：2020年9月13日
 */
public class Exist {

	 public boolean exist(char[][] board, String word) {
	        int h = board.length, w = board[0].length;
	        boolean[][] visited = new boolean[h][w];
	        for (int i = 0; i < h; i++) {
	            for (int j = 0; j < w; j++) {
	                boolean flag = check(board, visited, i, j, word, 0);
	                if (flag) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
	        if (board[i][j] != s.charAt(k)) {
	            return false;
	        } else if (k == s.length() - 1) {
	            return true;
	        }
	        visited[i][j] = true;
	        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	        boolean result = false;
	        for (int[] dir : directions) {
	            int newi = i + dir[0], newj = j + dir[1];
	            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
	                if (!visited[newi][newj]) {
	                    boolean flag = check(board, visited, newi, newj, s, k + 1);
	                    if (flag) {
	                        result = true;
	                        break;
	                    }
	                }
	            }
	        }
	        visited[i][j] = false;
	        return result;
	    }
}