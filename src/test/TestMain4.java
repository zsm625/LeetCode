package test;

import java.util.HashMap;
import java.util.Scanner;

public class TestMain4 {

	public static void main(String[] args) {
//		new HashMap();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if(str==null||str.length()==0) {
			System.out.println("请输入正确的内容");
		}
		String[] strArr = str.split(" ");
		for(int i=strArr.length-1;i>=0;i--) {
			System.out.print(strArr[i]+" ");
			
		}
	}
}
