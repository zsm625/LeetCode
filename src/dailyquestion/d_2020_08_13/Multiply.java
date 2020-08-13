package dailyquestion.d_2020_08_13;


/**
 * 字符串相乘
 *  给定两个以字符串形式表示的非负整数 num1 和 num2，
 *  返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * @author ZSM
 *
 * @time 2020年8月13日上午7:54:22
 */
public class Multiply {
	/**
	 * 最粗暴的先将两个字符串转为整数，然后进行乘积计算,实践证明结果太大，溢出pass
	 *@author ZSM
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply(String num1, String num2) {
		if(num1.length()==0) {
			return num2;
		}
		if(num2.length()==0) {
			return num1;
		}
		int len1 = num1.length();
		int len2 = num2.length();
		if(len1<len2) {
			return multiply(num2,num1);
		}else {
			int res1 = 0,res2=0;
			for(int i=0,j=0;i<len1;i++,j++) {
				if(j<len2) {
					int c2 = num2.charAt(j)-'0';
					res2 = res2*10+c2;
				}
				int c1 = num1.charAt(i)-'0';
				res1 = res1*10+c1;
			}
			long res = res1*res2;
			return String.valueOf(res);
		}
	}
	/**
	 * 
	 *@author ZSM
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply2(String num1,String num2) {
		if(num1.length()==0) {
			return num2;
		}
		if(num2.length()==0) {
			return num1;
		}
		if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
		int len1 = num1.length();
		int len2 = num2.length();
		if(len1<len2) {
			return multiply2(num2,num1);
		}else {
			//List<Integer> list = new ArrayList<Integer>();
			int[] arr = new int[len1+len2-1];
			for(int i=len2-1;i>=0;i--) {
				int t2 = num2.charAt(i)-'0';
				for(int j=len1-1;j>=0;j--) {
					int t1 = num1.charAt(j)-'0';
					arr[i+j]+=t1*t2;
				}
			}
			 StringBuilder sb = new StringBuilder();
			    int carry=0;
			    for (int i = arr.length - 1; i >= 0; i--) {
			        sb.append((arr[i]+carry)%10);
			        carry=(arr[i]+carry)/10;
			    }
			    while (carry != 0) {
			        sb.append(carry%10);
			        carry/=10;
			    }
			return sb.reverse().toString();
		}
	}
	public static void main(String[] args) {
		Multiply multiply = new Multiply();
		String string = multiply.multiply2("123456789", "987654321");
		System.out.println(string);
	}
}
