package office66;

/**
 * 简单一句话就是，你一个合法的括号序列，
 * 你需要将其拆分成两个合法的子序列（不连续），
 * 使得两个子序列的括号嵌套深度较大者尽量的小
 * @author ZSM
 *
 * @time 2020年4月1日上午11:18:04
 */
public class MaxDepthAfterSplit {
	
	public int[] maxDepthAfterSplit(String seq) {
		if(seq==null) {
			return new int[0];
		}
		int[] res = new int[seq.length()];
		int depth=0;
		for(int i=0;i<seq.length();i++) {
			if('('==seq.charAt(i)) {
				res[i]=depth++%2;
			}else {
				res[i] = --depth%2;
			}
		}
		return res;
	}

}
