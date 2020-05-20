package p10;

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，
 * 现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * @author ZSM
 *
 * @time 2019年9月30日上午9:30:44
 */
public class Fibonacci {
	private int[] f = new int[40];
	public Fibonacci() {
		f[1]=1;
		for(int i=2;i<f.length;i++) {
			f[i] = f[i-2]+f[i-1];
		}
	}

	public int Fibonacci3(int n) {
		return f[n];
	}
	
	public int Fibonacci1(int n) {
		if(n>39 || n<=0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		
		int result = Fibonacci1(n-1)+Fibonacci1(n-2);
		
		return result;
    }
	
	public int Fibonacci2(int n) {
		if(n==1) {
			return 1;
		}
		int pre1 = 0;
		int pre2 = 1;
		for(int i=2;i<=n;i++) {
			int cur = pre1+pre2;
			pre1=pre2;
			pre2=cur;
		}
		
		return pre2;
	}
	
	
	public static void main(String[] args) {
		Fibonacci test1 = new Fibonacci();
		int i = test1.Fibonacci3(10);
		System.out.println(i);
	}
	
	
}
