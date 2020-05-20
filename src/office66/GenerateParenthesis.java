package office66;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {

	private List<String> list = new ArrayList<>();
	public List<String> generateParenthesis(int n){
		if(n<=0) {
			return list;
		}
		String sb = new String("");
		dfs(sb,n,n);
		return list;
		
	}
	public void dfs(String sb,int left,int right) {
		if(left==0 && right==0) {
			list.add(sb);
		}
		if(left>right) {
			return;
		}
		if(left>0) {
			dfs(sb+"(",left-1,right);
		}
		if(right > left) {
			dfs(sb+")",left,right-1);
		}
	}
	
	public static void main(String[] args) {
		GenerateParenthesis parenthesis = new GenerateParenthesis();
		List<String> list2 = parenthesis.generateParenthesis(3);
		for (String string : list2) {
			System.out.println(string);
		}
	}
}
