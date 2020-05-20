package p20;

/**
 * 判断是否为数字值
 * 
 * @author ZSM
 *
 * @time 2019年10月8日上午11:22:35
 */
public class IsNumeric {

	public boolean isNumeric(char[] str) {
		if (str == null || str.length == 0) {
			return false;
		}
		String regex = "^([\\+\\-])?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?$";
		boolean flag = false;
		String str0 = String.valueOf(str);
		flag = str0.matches(regex);
		if (!flag) {
			return false;
		}
		return flag;
	}

	public static void main(String[] args) {
		IsNumeric isNumeric = new IsNumeric();
		System.out.println(isNumeric.isNumeric(new char[] {'1','a','.','1'}));
	}
}
