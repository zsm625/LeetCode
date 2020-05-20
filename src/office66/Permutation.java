package office66;

import java.util.HashSet;
import java.util.Set;

/**
 * 全排列
 * @author ZSM
 *
 * @time 2020年3月22日下午12:42:40
 */
public class Permutation {

	Set<String> set = new HashSet<>();
	/**
	 * 交换的方法
	 * 完全没明白
	 * 
	 *@author ZSM
	 * @param s
	 * @return
	 */
	public String[] permutation(String s) {
		char[] chars = s.toCharArray();
		help(chars,0);
		
		return set.toArray(new String[0]);
	}
	public void help(char[] chars,int index) {
		if(index ==chars.length) {
			String s = new String(chars);
			set.add(s);
		}
		for(int i=index;i<chars.length;i++) {
			if(i==index) {
				help(chars,index+1);
				continue;
			}
			for(int j = i-1;j>=index;j--) {
				if(chars[j]==chars[i]) break;
			}
			
			swap(chars,i,index);
			help(chars,index+1);
			swap(chars,i,index);
		}
	}
	
	private void swap(char[] chars,int i,int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
	
	public static void main(String[] args) {
		Permutation p = new Permutation();
		String[] strings = p.permutation("abc");
		for(int i=0;i<strings.length;i++) {
			System.out.print(strings[i]+"\t");
		}
	}
}
