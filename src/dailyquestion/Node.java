package dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的节点
 * 
 * 
 * @author ZSM
 *
 * @time 2020年8月12日上午8:13:33
 */
public class Node {
	//每个节点都包含它的值 val（int） 和其邻居的列表
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}

}
