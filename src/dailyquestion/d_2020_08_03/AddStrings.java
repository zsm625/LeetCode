package dailyquestion.d_2020_08_03;

/**
 * 字符串相加
 * 
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * @author ZSM
 *
 * @time 2020年8月3日下午1:11:34
 */
public class AddStrings {

	/**
	 * 双指针
	 * 
	 *@author ZSM
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addString(String num1,String num2) {
		if (num1 == null) {
			return num2;
		}
		if (num2 == null) {
			return num1;
		}
		int i = num1.length() - 1, j = num2.length() - 1, add = 0;
		StringBuffer ans = new StringBuffer();
		while (i >= 0 || j >= 0 || add != 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int result = x + y + add;
			ans.append(result % 10);
			add = result / 10;
			i--;
			j--;
		}
		// 计算完以后的答案需要翻转过来
		ans.reverse();
		return ans.toString();
	}
	public static void main(String[] args) {
		AddStrings strings = new AddStrings();
		strings.addString("4567", "234");
	}
}
