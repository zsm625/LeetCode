package dailyquestion.d_2020_08_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回文串
 * 
 * @author ZSM
 *
 * @time 2020年8月6日上午7:59:24
 */
public class PalindromePairs {
	class Trie {
		public Trie[] children;
		public List<Integer> suffix;
		public List<Integer> words;

		public Trie() {
			this.children = new Trie[26];
			this.words = new ArrayList<Integer>();
			this.suffix = new ArrayList<Integer>();
		}
	}

	private Trie root;

	/**
	 * 判断两个字符串是否能形成回文，有三种情况，s1.length=k1，s2.length=k2 1、k1==k2，回文判断
	 * 2、k1<k2，如果是回文，就会存在k2的子序列t2与k1是回文，同时k2剩下的子序列是一个回文 3、k1>k2 跟上述情况相反 使用字典树
	 * 
	 * @author ZSM
	 * @param words
	 * @return
	 */
	public List<List<Integer>> palindromePairs(String[] words) {
		this.root = new Trie();
		int n = words.length;
		for (int i = 0; i < n; i++) {
			String rev = new StringBuilder(words[i]).reverse().toString();
			Trie cur = root;
			if (isPalindrome(rev.substring(0))) {
				cur.suffix.add(i);
			}
			for (int j = 0; j < rev.length(); j++) {
				char ch = rev.charAt(j);
				if (cur.children[ch - 'a'] == null) {
					cur.children[ch - 'a'] = new Trie();
				}
				cur = cur.children[ch - 'a'];
				if (isPalindrome(rev.substring(j + 1))) {
					cur.suffix.add(i);
				}
			}
			cur.words.add(i);
		}
		// 用来存放答案的列表
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String word = words[i];
			Trie cur = root;
			int j = 0;
			for (; j < word.length(); j++) {
				// 到j位置，后序字符串若是回文对，则在该节点位置上所有单词都可以与words[i]构成回文
				// 因为插入时是用每个单词的逆序插入的
				if (isPalindrome(word.substring(j))) {
					for (int k : cur.words) {
						if (k != i) {
							res.add(Arrays.asList(i, k));
						}
					}
				}
				char ch = word.charAt(j);
				if (cur.children[ch - 'a'] == null) {
					break;
				}
				cur = cur.children[ch - 'a'];
			}
			if (j == word.length()) {
				for (int k : cur.suffix) {
					if (k != i) {
						res.add(Arrays.asList(i, k));
					}

				}
			}
		}
		return res;
	}

	/**
	 * 判断一个字符串是否为回文
	 * 
	 * @author ZSM
	 * @param word
	 * @return
	 */
	public boolean isPalindrome(String word) {
		int i = 0, j = word.length() - 1;
		while (i <= j) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
