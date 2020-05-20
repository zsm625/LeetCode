package office66;

/**
 * 计算
 * @author ZSM
 *
 * @time 2020年3月17日下午5:35:54
 */
public class CountCharacters {
	
	/**
	 * 使用数组来计算字符出现的次数
	 * 但是第一种方式需要消耗好多的内存空间，还有时间复杂度是O(n2),空间复杂度是O(N)
	 *@author ZSM
	 * @param words
	 * @param chars
	 * @return
	 */
	public int countCharacters(String[] words,String chars) {
		int res = 0;
		int[] char_count = count(chars);
		for(int i=0;i<words.length;i++) {
			int[] word_count = count(words[i]);
			if(contains(char_count,word_count)) {
				res+=words[i].length();
			}
			
		}
		
		return res;
	}
	
	public boolean contains(int[] char_count,int[] word_count) {
		for(int i=0;i<26;i++) {
			if(char_count[i]<word_count[i]) {
				return false;
			}
		}
		return true;
		
	}
	
	
	/**
	 * 使用数组来计算字符出现的次数
	 *@author ZSM
	 * @param word
	 * @return
	 */
	public int[] count(String word) {
		int[] count = new int[26];
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			count[c-'a']++;
		}
		return count;
	}

}
