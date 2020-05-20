package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个list删除目标元素的函数，
 * 然后写个测试用例测试一下能不能通，
 * 为什么不能正向遍历

 * @author ZSM
 *
 * @time 2019年10月29日下午9:11:28
 */
public class TestMain7 {
	
	public List testRemove(List list,Object target) {
		if(list.contains(target)) {
			list.remove(target);
		}
		return list;
	}
	public static void main(String[] args) {
		TestMain7 main7 = new TestMain7();
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		List list2 = main7.testRemove(list, "4");
		for (Object object : list2) {
			System.out.println(object);
		}
	}
}
