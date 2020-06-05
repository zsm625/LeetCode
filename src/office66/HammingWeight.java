package office66;

/**
 * 请实现一个函数，输入一个整数，
 * 输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。
 * 因此，如果输入 9，则该函数输出 2
 * @author ZSM
 *
 * @time 2020年6月5日下午1:13:21
 */
public class HammingWeight {

	/**
	 * 采用位运算
	 * n&1 = 0,最后一位是0；
	 * n&1=1,最后一位是1；
	 * 循环上面的计算，对==1的情况进行累加
	 * 时间复杂度为O(log2N) N是n的位数
	 * 空间复杂度为O(1)
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int hammingWeight(int n) {
		if(n==0) {
			return 0;
		}
		int res=0;
		//如果是11111111111111111111111111111101,他是一个负数，不能使用n>0的条件
		while(n!=0) {
			res+=n&1;
			n=n>>>1;
		}
		return res;
	}
	
	/**
	 * 将n后面的1都转成了0；
	 * n&(n-1)
	 * 时间复杂度为O(M)M是1的个数
	 * 空间复杂度O(1)
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int hammingWeight2(int n) {
		int res = 0;
		while(n!=0) {
		    res++;
		    n=n&(n-1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		HammingWeight weight = new HammingWeight();
		int i = weight.hammingWeight(11111);
		System.out.println(i);
	}
}
