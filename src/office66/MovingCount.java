package office66;

/**
 * 机器人的运动轨迹
 * @author ZSM
 *
 * @time 2020年4月7日下午5:24:49
 */
public class MovingCount {

	public int movingCount(int m,int n,int k) {
		int[][] visited = new int[m][n];
		
		return dfs(0,0,m,n,visited,k);
	}
	private int dfs(int i,int j,int m,int n,int[][] visited,int k) {
		if(add(i,j)>k || i>m-1 || j>n-1 || visited[i][j]==1) {
			return 0;
		}
		visited[i][j]=1;
		return 1+dfs(i+1,j,m,n,visited,k)+dfs(i,j+1,m,n,visited,k);
		
	}
	
	private int add(int a,int b) {
		int result=0;
		while(a!=0) {
			result+=a%10;
			a/=10;
		}
		while(b!=0) {
			result+=b%10;
			b/=10;
		}
		return result;
	}
}
