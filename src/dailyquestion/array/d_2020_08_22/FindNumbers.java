package dailyquestion.array.d_2020_08_22;

/**
 * Find Numbers with Even Number of Digits
 * Given an array nums of integers, 
 * return how many of them contain an even number of digits.
 * 给定一组数字，统计是偶数位的数字有多少个
 * @author Administrator
 *
 */
public class FindNumbers {
	public int findNumbers(int[] nums) {
		int res = 0;
		//尝试一下导巧的方法
		for(int num:nums) {
			String s = Integer.toString(num);
			if(s.length()%2==0) {
				res++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		FindNumbers numbers = new FindNumbers();
		int[] nums = {1,345,2,6,78348};
		int i = numbers.findNumbers(nums);
		System.out.println(i);
		
	}

}
