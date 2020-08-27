package dailyquestion.d_2020_08_27;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，
 * 子数组中的两个成员分别表示飞机出发和降落的机场地点，
 * 对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，
 * 所以该行程必须从 JFK 开始。
 * @author Administrator
 *
 */
public class FindItinerary {

	public List<String> findItinerary(List<List<String>> tickets){
		List<String> res = new LinkedList<>();
		if(tickets==null || tickets.size()==0) {
			return res;
		}
		Map<String,PriorityQueue<String>> map = new HashMap<>();
		for(List<String> pair:tickets) {
			PriorityQueue<String> queue = map.computeIfAbsent(pair.get(0), k->new PriorityQueue<String>());
			queue.add(pair.get(1));
		}
		visted(map,"JFK",res);
		return res;
	}
	
	public void visted(Map<String,PriorityQueue<String>> map,String src,List<String> res) {
		PriorityQueue<String> queue = map.get(src);
		while(queue!=null && queue.size()>0) {
			String dest = queue.poll();
			visted(map,dest,res);
		}
		res.add(0,src);
	}
}
