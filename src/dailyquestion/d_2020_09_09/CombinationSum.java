package dailyquestion.d_2020_09_09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 组合的总和
 * @author zsm
 *
 *         时间：2020年9月9日
 */
public class CombinationSum {
	/**
	 * 组合的总和I
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		int len = candidates.length;
		List<List<Integer>> res = new ArrayList<>();
		if (len == 0) {
			return res;
		}

		Deque<Integer> path = new ArrayDeque<>();
		dfs(candidates, 0, len, target, path, res);
		return res;
	}

	/**
	 * @param candidates 候选数组
	 * @param begin      搜索起点
	 * @param len        冗余变量，是 candidates 里的属性，可以不传
	 * @param target     每减去一个元素，目标值变小
	 * @param path       从根结点到叶子结点的路径，是一个栈
	 * @param res        结果集列表
	 */
	private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
		// target 为负数和 0 的时候不再产生新的孩子结点
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}

		// 重点理解这里从 begin 开始搜索的语意
		for (int i = begin; i < len; i++) {
			path.addLast(candidates[i]);

			// 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
			dfs(candidates, i, len, target - candidates[i], path, res);

			// 状态重置
			path.removeLast();
		}
	}

	/**
	 * 组合的总和II
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		int len = candidates.length;
		List<List<Integer>> res = new ArrayList<>();
		if(len==0) {
			return res;
		}
		Arrays.sort(candidates);
		Deque<Integer> path = new ArrayDeque<>();
		dfs2(candidates,0,len,target,path,res);
		return res;
	}
	public void dfs2(int[] candidates,int begin,int len,int target,Deque<Integer> path,List<List<Integer>> res) {
		if(target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		
		for(int i=begin;i<len;i++) {
			if(target-candidates[i]<0) {
				break;
			}
			if(i>begin && candidates[i] == candidates[i-1]) {
				continue;
			}
			path.addLast(candidates[i]);
			dfs2(candidates,i+1,len,target-candidates[i],path,res);
			path.removeLast();
		}
	}
	public static void main(String[] args) {
		CombinationSum sum = new CombinationSum();
		int[] candidates = {10,1,2,7,6,1,5};
		sum.combinationSum2(candidates, 8);
	}
}
