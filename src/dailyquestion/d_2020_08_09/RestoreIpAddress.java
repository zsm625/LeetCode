package dailyquestion.d_2020_08_09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），
 * 整数之间用 '.' 分隔。
 * @author ZSM
 *
 * @time 2020年8月9日上午7:43:05
 */
public class RestoreIpAddress {
	
	/**
	 * 回溯法
	 *@author ZSM
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddress(String s){
		int len = s.length();
		List<String> res = new ArrayList<>();
		if(len<4||len>12) {
			return res;
		}
		Deque<String> path = new ArrayDeque<>(4);
		dfs(s,len,0,4,path,res);
		return res;
	}
	//residue记录还有多少段没有被分割
	public void dfs(String s,int len,int begin,int residue,Deque<String> path,List<String> res ) {
		if(begin == len) {
			if(residue==0) {
				res.add(String.join(".", path));
			}
			return; 
		}
		
		for(int i=begin;i<begin+3;i++) {
			if(i>=len) {
				break;
			}
			if(residue*3<len-i) {
				continue;
			}
			if(judgeIpSegment(s,begin,i)) {
				String currentIpSegment = s.substring(begin,i+1);
//				System.out.println("currentIpSegment:  "+currentIpSegment);
				path.addLast(currentIpSegment);
				
				dfs(s,len,i+1,residue-1,path,res);
				path.removeLast();
			}
		}		
	}

	//判断IP是否符合规范
	public boolean judgeIpSegment(String s,int left,int right) {
		int len = right-left+1;
		if(len>1&&s.charAt(left)=='0') {
			return false;
		}
		int res = 0;
		while(left<=right) {
			res = res*10+s.charAt(left)-'0';
			left++;
		}
		return res>=0 && res<=255;
	}
	public static void main(String[] args) {
		RestoreIpAddress address = new RestoreIpAddress();
		List<String> ipAddress = address.restoreIpAddress("25525511135");
		for (String string : ipAddress) {
			System.out.println(string);
		}
	}
}
