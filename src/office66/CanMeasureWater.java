package office66;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 水壶的问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。
 * 请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 *   装满任意一个水壶
 *   清空任意一个水壶
 *   从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * @author ZSM
 *
 * @time 2020年3月21日上午10:31:10
 */
public class CanMeasureWater {
	/**
	 * 使用深度优先遍历
	 * 
	 *@author ZSM
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public boolean canMeasureWater(int x,int y,int z) {
		if(z==0 || x==z || y==z || x+y==z ) {
			return true;
		}
		if(x+y<z) {
			return false;
		}
		Queue<List<Integer>> queue = new LinkedList<>();
		Set<List<Integer>> set = new HashSet<>();
		List<Integer> list = Arrays.asList(0,0);
		queue.add(list);
		set.add(list);
		while(!queue.isEmpty()) {
			List<Integer> temp = queue.poll();
			int cur_x = temp.get(0);
			int cur_y = temp.get(1);
			if(z==cur_x || z==cur_y || z==cur_x+cur_y) {
				return true;
			}
			//接下来罗列出现的6中操作情况
			//1、给x加满
			List<Integer> condition1 = Arrays.asList(x,cur_y);
			if(!set.contains(condition1)) {
				set.add(condition1);
				queue.offer(condition1);
			}
			//2、给y加满
			List<Integer> condition2 = Arrays.asList(cur_x,y);
			if(!set.contains(condition2)) {
				set.add(condition2);
				queue.add(condition2);
			}
			//3、给x清空
			List<Integer> condition3 = Arrays.asList(0,cur_y);
			if(!set.contains(condition3)) {
				set.add(condition3);
				queue.add(condition3);
			}
			//4、给y清空
			List<Integer> condition4 = Arrays.asList(cur_x,0);
			if(!set.contains(condition4)) {
				set.add(condition4);
				queue.add(condition4);
			}
			//5、用x给y加水
			List<Integer> condition5 = (cur_x+cur_y>y)?Arrays.asList(cur_x+cur_y-y,y):Arrays.asList(0,cur_x+cur_y);
			if(!set.contains(condition5)) {
				set.add(condition5);
				queue.add(condition5);
			}
			//6、用y给x加水
			List<Integer> condition6 = (cur_x+cur_y>x)?Arrays.asList(x,cur_x+cur_y-x):Arrays.asList(cur_x+cur_y,0);
			if(!set.contains(condition6)) {
				set.add(condition6);
				queue.add(condition6);
			}	
		}
		
		return false;
	}

	/**
	 * 数学定理 
	 * ax+by=z 有解当且仅当 z是 x,y 的最大公约数的倍数。
	 * 因此我们只需要找到 x,y 的最大公约数并判断 z 是否是它的倍数即可。
	 *@author ZSM
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public boolean canMeasureWater2(int x,int y,int z) {
		if(x+y<z) {
			return false;
		}
		if(x==0 || y==0) {
			return y==z || x==z;
		}
		return z % gcb(x,y)==0;
	}
	/**
	 * 求两个数的最大公因子
	 *@author ZSM
	 * @param x
	 * @param y
	 * @return
	 */
	private int gcb(int x,int y) {
		return y==0?x:gcb(y,x%y);
		
	}
}
