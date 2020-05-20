package office66;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 判断一组数能不能组成一组或者多组相同的数组，
 * @author ZSM
 *
 * @time 2020年3月27日下午12:08:14
 */
public class HasGroupsSizeX {
	public boolean hasGroupsSizeX(int[] deck) {
		if(deck==null || deck.length==0) {
			return false;
		}
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<deck.length;i++) {
			if(map.containsKey(deck[i])) {
				map.put(deck[i], map.get(deck[i])+1);
			}else {
				map.put(deck[i], 1);
			}
		}
		
		Set<Integer> keySet = map.keySet();
		int g = -1;
		for (Integer i : keySet) {
			if(g==-1) {
				g=map.get(i);
			}else {
				g = gcd(g,map.get(i));
			}
		}
		return g>=2;
		
	}
	private int gcd(int x ,int y) {
		return x==0?y:gcd(y%x,x);
	}
}
