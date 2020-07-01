package office66;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * 输入一个非负整数数组，
 * 把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * @author ZSM
 *
 * @time 2020年7月1日下午9:45:21
 */
public class MinNumber {

	/**
	 * 对数组中的数字字符进行一个排序
	 * 如x+y>y+x，（+拼接）m>n
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public String minNumber(int[] nums) {
		if(nums==null || nums.length==0) {
			return null;
		}
		int len = nums.length;
		String[] str = new String[len];
		//将nums进行类型转换
		for(int i=0;i<len;i++) {
			str[i] = Integer.toString(nums[i]);
		}
		//将x+y与y+x进行比较，为str中的元素交换位置
		for(int i=1;i<len;i++) {
			for(int j=0;j<i;j++) {
				if((str[j]+str[i]).compareTo(str[i]+str[j])>0) {
					String temp = str[i];
					str[i] = str[j];
					str[j]=temp;
				}
			}
		}
		String res = "";
		for(int i=0;i<len;i++) {
			res+=str[i];
		}
		
		return res;
	}
	public static void main(String[] args) {
		MinNumber number = new MinNumber();
		int[] nums= {3,30,34,5,9};
		String minNumber = number.minNumber(nums);
		System.out.println(minNumber);
	}
}
