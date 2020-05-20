package office66;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 单词的压缩编码
 * 给定一个单词列表，
 * 我们将这个列表编码成一个索引字符串S和一个索引列表A
 * 例如，如果这个列表是 ["time", "me", "bell"]，
 * 我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，
 * 直到 "#" 结束，来恢复我们之前的单词列表。
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * @author ZSM
 *
 * @time 2020年3月28日上午9:53:46
 */
public class MinimumLengthEncoding {

	/**
	 * 第一种存储法
	 * 思路：如果单词X是Y的后缀，那么X就不需要考虑了，因为编码的时候Y已经编码了
	 * 如果单词Y不在任何单词的后缀中出现，那么Y一定是字符编码中的一个
	 * 因此，解题的突破点就是保留不是其他单词后缀的单词，最后的结果就是所有单个单词长度+1
	 *@author ZSM
	 * @param words
	 * @return
	 */
	public int minimumLengthEncoding(String[] words) {
		Set<String> all = new HashSet<String>(Arrays.asList(words));
		for(String word:words) {
			for(int k=1;k<word.length();k++) {
				all.remove(word.substring(k));
			}
		}
		int ans = 0;
		for(String word:all) {
			ans+=word.length()+1;
		}
			return ans;
	}
	
	/**
	 * 字典树 ??
	 *@author ZSM
	 * @param words
	 * @return
	 */
	public int minimumLengthEncoding2(String[] words) {
		TrieNode trie = new TrieNode();
		Map<TrieNode,Integer> nodes = new HashMap<>();
		for(int i=0;i<words.length;i++) {
			String word = words[i];
			TrieNode cur = trie;
			for(int j=word.length()-1;j>=0;j--) {
				cur = cur.get(word.charAt(j));
			}
			nodes.put(cur, i);
		}
		int ans = 0;
		for(TrieNode node : nodes.keySet()) {
			if(node.count==0) {
				ans+=words[nodes.get(node)].length()+1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		MinimumLengthEncoding encoding = new MinimumLengthEncoding();
		String[] words = {"time","me","bell"};
		int i = encoding.minimumLengthEncoding2(words);
		System.out.println(i);
		
	}
}

class TrieNode{
	TrieNode[] children;
	int count;
	TrieNode(){
		children = new TrieNode[26];
		count=0;
	}
	public TrieNode get(char c) {
		if(children[c-'a']==null) {
			children[c-'a']=new TrieNode();
			count++;
		}
		return children[c-'a'];
	}
}