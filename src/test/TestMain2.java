package test;

import java.math.BigDecimal;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
//		Integer x = 12345;
//		String string = Integer.toBinaryString(x);
		Scanner sc = new Scanner(System.in);
		System.out.print("输入一个数字（<=4294967295):");
//		int num = sc.nextInt();
		String s = sc.nextLine();
		Integer i2 = new Integer(s);
//		String x=42949672695;
		Long i1 = new Long("4294967295");
		int count = 0;
		if (i2 > i1) {
			count = 0;
		} else {
//			i2 =(Integer)i2;
			String tempNum = Integer.toBinaryString(i2);
			String[] split = tempNum.split("");
			for (int i = 0; i < split.length; i++) {
				if ("1".equals(split[i])) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
