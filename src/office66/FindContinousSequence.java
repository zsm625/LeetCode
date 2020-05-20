package office66;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出和为target的数组序列 将数组从大到小排列
 * 
 * @author ZSM
 *
 * @time 2020年4月8日上午10:00:59
 */
public class FindContinousSequence {
	public int[][] findContinousSequence(int target) {
		if (target <= 0) {
			return new int[0][0];
		}
		List<List<Integer>> list = new ArrayList<>();
		int head = 1;
		// 自己写的第一种
		// 思路：使用两个指针，
		int sum = 0;
		List<Integer> array = new ArrayList<>();
		for (int i = 1; i <= target + 1 >> 1; i++) {
			array.add(i);
			sum += i;
			while (sum > target) {
				array.remove(0);
				sum -= head;
				head++;
			}
			if (sum == target) {
				list.add(new ArrayList<>(array));
			}

		}

		return toDoubleArray(list);

	}

	private int[][] toDoubleArray(List<List<Integer>> list) {
		int[][] res = new int[list.size()][];
		int j = 0;
		while (j < list.size()) {
			for (List<Integer> l : list) {
				int[] arr = new int[l.size()];
				for (int i = 0; i < l.size(); i++) {
					arr[i] = l.get(i);
				}
				res[j] = arr;
				j++;
			}

		}
		return res;

	}

	public static void main(String[] args) {
		FindContinousSequence sequence = new FindContinousSequence();
		int[][] is = sequence.findContinousSequence(9);
		for (int i = 0; i < is.length; i++) {
			for (int j = 0; j < is[i].length; j++) {
				System.out.print(is[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
