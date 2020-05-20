package office66;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中剩下的最后一个数
 * @author ZSM
 *
 * @time 2020年3月30日上午10:16:53
 */
public class LastRemaining {

	public int lastRemaining(int n,int m) {
		if(m==0 || n==0) {
			return -1;
		}
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(i);
		}
		int c = (m-1)%n;
		while(list.size()!=1) {
			list.remove(c);
			c = (c+m-1)%list.size();
		}
		return list.get(0);
	}
	
	public int lastRemaining2(int n,int m) {
		int f= 0;
		for(int i=2;i!=n+1;i++) {
			f = (m+f)%i;
		}
		return f;
	}
}
