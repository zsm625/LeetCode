package dailyquestion.d_2020_08_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表
 * 
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，
 * 我们用一个匹配来表示他们：[0,1]给定课程总量以及它们的先决条件，
 * 请你判断是否可能完成所有课程的学习？
 * @author ZSM
 *
 * @time 2020年8月4日上午9:32:12
 */
public class CanFinish {

	List<List<Integer>> edges;
	int[] visited;
	boolean valid = true;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<List<Integer>>();
		for (int i = 0; i < numCourses; ++i) {
			edges.add(new ArrayList<Integer>());
		}
		visited = new int[numCourses];
		for (int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
		}
		for (int i = 0; i < numCourses && valid; ++i) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}
		return valid;
	}

	public void dfs(int u) {
		visited[u] = 1;
		for (int v : edges.get(u)) {
			if (visited[v] == 0) {
				dfs(v);
				if (!valid) {
					return;
				}
			} else if (visited[v] == 1) {
				valid = false;
				return;
			}
		}
		visited[u] = 2;
	}
}
