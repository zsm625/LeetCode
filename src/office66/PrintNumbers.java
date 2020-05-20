package office66;

/**
 * 打印1到n的最大树
 * @author ZSM
 *
 * @time 2020年3月17日下午6:56:41
 */
public class PrintNumbers {

	public int[] printNumbers(int n) {
		int temp = 1;
		for(int i=0;i<n;i++) {
			temp*=10;
		}
		int[] res = new int[temp-1];
		for(int j = 0;j<res.length;j++) {
			res[j] = j+1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		PrintNumbers print = new PrintNumbers();
		int[] is = print.printNumbers(-1);
		for(int i=0;i<is.length;i++) {
			if(i%10==9) {
				System.out.println();
			}
			System.out.print(is[i]+"\t");
		}
	}
}
