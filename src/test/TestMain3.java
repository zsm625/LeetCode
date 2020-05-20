package test;

import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain3 {

	public static void main(String[] args) {
		TestMain3 main = new TestMain3();
		main.test("abceefgQQ12345hgderQ123hgnbeQ456ghyt");
	}
	
	public void test(String str) {
//		String[] tempStr = str.split("");
		String regex1 = "\\w*Q+\\d+\\w*";
		String regex = "Q+\\d+";
		int count=0;
		String[] split = str.split("Q+\\d+");
		while(str.matches(regex1)) {
		count++;
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(str);
		 str = matcher.replaceFirst("text"+count);
		}
//		str.matches(regex);
		System.out.println(str);
		
		
	}
}
