package day_9_15;

import java.util.Arrays;

/**
 * 任务调度器：
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。
 * 其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
 * CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，
 * 因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 * 
 * @author ZSM
 *
 * @time 2019年9月15日下午4:06:45
 */
public class LeastInterval {
	
	public int leastInterval(char[] tasks,int n) {
		//用于统计词频
		int[] count = new int[26];
		for(int i=0;i<tasks.length;i++) {
			count[tasks[i]-'A']++;
		}
		//词频排序，升序，count[25]是频率最高的
		Arrays.sort(count);
		System.out.println(Arrays.toString(count));
		int maxCount=0;
		for(int j=25;j>=0;j--) {
			//计算词频相同的个数
			if(count[j]!=count[25]) {
				break;
			}
			maxCount++;
		}
//		System.out.println(maxCount );
		return Math.max((count[25]-1)*(n+1)+maxCount, tasks.length);
	}

	public static void main(String[] args) {
		char[] tasks= {'A','A','B','B'};
		int n=0;
		System.out.println(new LeastInterval().leastInterval(tasks, n));
		
	}
}
