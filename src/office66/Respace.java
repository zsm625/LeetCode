package office66;

/**
 * 恢复空格
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，
 * 并且大写也弄成了小写。
 * 像句子"I reset the computer. It still didn’t boot!"
 * 已经变成了"iresetthecomputeritstilldidntboot"。
 * 在处理标点符号和大小写之前，你得先把它断成词语。
 * 当然了，你有一本厚厚的词典dictionary，
 * 不过，有些词没在词典里。
 * 假设文章用sentence表示，设计一个算法，
 * 把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * @author ZSM
 *
 * @time 2020年7月9日上午9:51:57
 */
public class Respace {

	/**
	 * 字典树+动态规划
	 * 动态规划来记录只有前i个字符，最少的未识别字符
	 * 字典树来优化dictionary的 搜索
	 * 
	 * 
	 *@author ZSM
	 * @param dictionary
	 * @param sentence
	 * @return
	 */
	public int respace(String[] dictionary,String sentence) {
		if(null == sentence || sentence.length()==0) {
			return 0;
		}
		RevertTree root = new RevertTree();
		initRevertTree(dictionary,root);
		int[] record = new int[sentence.length()+1];
		for(int i=1;i<=sentence.length();i++) {
			String now = sentence.substring(0,i);
			int min = record[i-1]+1;
			RevertTree temp = root;
			int j=0;
			while(temp!=null && i-1-j>=0) {
				char c = sentence.charAt(i-1-j);
				temp = temp.childs[c-'a'];
				if(temp!=null && temp.isEnd) {
					min = Math.min(min, record[now.length()-(j+1)]);
				}
				j++;
			}
			record[i] = min;
		}
		return record[sentence.length()];
	}
	
	public void initRevertTree(String[] dictionary,RevertTree root) {
		for (String word : dictionary) {
			String revertWord = new StringBuilder(word).reverse().toString();
			RevertTree temp = root;
			for(char c:revertWord.toCharArray()){
				temp = temp.addChar(c);
			}
			temp.isEnd = true;
		}
		
	}
	static class RevertTree {
		RevertTree[] childs = new RevertTree[26];
		boolean isEnd = false;
		RevertTree addChar(char c) {
			int index = c-'a';
			if(childs[index]==null) {
				childs[index] = new RevertTree();
			}
			return childs[index];
		}
	}
	
	public static void main(String[] args) {
		Respace respace = new Respace();
		String[] dictionary = {"looked","just","like","her","brother"};
		String sentence = "jesslookedjustliketimherbrother";
		int i = respace.respace(dictionary, sentence);
		System.out.println(i);
	}
}


