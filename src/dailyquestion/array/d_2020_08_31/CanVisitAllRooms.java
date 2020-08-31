package dailyquestion.array.d_2020_08_31;

import java.util.List;

/**
 * 841. 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。
 * 每个房间有不同的号码：0，1，2，...，N-1，
 * 并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，
 * 每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，
 * 其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * 如果能进入每个房间返回 true，否则返回 false。
 * @author zsm
 *
 *     时间：2020年8月31日
 */
public class CanVisitAllRooms {

	boolean[] vis;
	int num;

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size();
		num = 0;
		vis = new boolean[n];
		dfs(rooms, 0);
		return num == n;
	}

	public void dfs(List<List<Integer>> rooms, int x) {
		vis[x] = true;
		num++;
		for (int it : rooms.get(x)) {
			if (!vis[it]) {
				dfs(rooms, it);
			}
		}
	}
}
