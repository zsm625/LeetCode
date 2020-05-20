package office66;

/**
 * 两个数相加，但是不使用加减乘除符号
 * @author ZSM
 *
 * @time 2020年3月24日上午11:32:58
 */
public class Add {

	public int add(int a, int b) {
		while(b!=0) {
			int plus = a^b;
			b = (a&b)<<1;
			a = plus;
		}
		return a;
	}
	public static void main(String[] args) {
		Add add = new Add();
		int i = add.add(2, 3);
		System.out.println(i);
	}
}
