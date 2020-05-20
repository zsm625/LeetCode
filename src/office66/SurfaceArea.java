package office66;

/**
 * 三维立体形表面积
 * @author ZSM
 *
 * @time 2020年3月25日上午9:46:36
 */
public class SurfaceArea {

	public int surfaceArea(int[][] grid) {
		int n = grid.length; 
		int area = 0;
		for(int i=0;i<n;i++) {
			for(int j = 0;j<grid[i].length;j++) {
				int level = grid[i][j];
				if(level>0) {
					//一个柱体中，表面积=2个底面+所有正方体都贡献了4个侧面
					area+=(level<<2)+2;
					//减掉i与i-1之间贴合的两个表面积
					//两个贴合的表面积为，两个柱体的高的最小值*2
					area-=i>0?Math.min(level,grid[i-1][j])<<1:0;
					area-=j>0?Math.min(level, grid[i][j-1])<<1:0;
				}
			}
		}
		return area;
	}
}
