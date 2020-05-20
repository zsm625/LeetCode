package p20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 将数组中的奇数移到偶数前并保证他们的相对位置不变
 * @author ZSM
 *
 * @time 2019年10月8日下午3:32:18
 */
public class ReOrderArray {

	/**
	 * 第一种新建一个数组
	 *@author ZSM
	 * @param arr
	 * @return
	 */
	public int[] reOrderArray(int[] arr) {
		int oddCount =0;
		int[] result = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			if(!isEvent(arr[i])) {
				result[oddCount]=arr[i];
				oddCount++;
			}
		}
		
		for(int i=0,j=oddCount;j<arr.length&&i<arr.length;i++) {
			int num=arr[i];
			if(num%2==0) {
				result[j++]=num;
			}
		}
		
		return result;
	}
	private boolean isEvent(int num) {
		return num%2==0;
	}
	public static void main(String[] args) {
		ReOrderArray array = new ReOrderArray();
		int[] arr = {1,2,3,4,5,6,7};
		int[] is = array.reOrderArray(arr);
		for(int i=0;i<is.length;i++) {
			System.out.print(is[i]);
		}

		try {
			Connection conn = DriverManager.getConnection("");
			Statement a = conn.createStatement();
			a.execute("");
			a.executeQuery("");
			PreparedStatement p = conn.prepareStatement("");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
