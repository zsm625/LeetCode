package office66;

/**
 * 跳水板
 * 你正在使用一堆木板建造跳水板。
 * 有两种类型的木板，其中长度较短的木板长度为shorter，
 * 长度较长的木板长度为longer。你必须正好使用k块木板。
 * 编写一个方法，生成跳水板所有可能的长度。
 * @author ZSM
 *
 * @time 2020年7月8日上午9:10:40
 */
public class DivingBoard {
	/**
	 * 
	 *@author ZSM
	 * @param shorter
	 * @param logner
	 * @param k
	 * @return
	 */
	public int[] divingBoard(int shorter,int longer,int k) {
		if(k==0) {
			return new int[0];
		}
		if(shorter==longer) {
			return new int[] {shorter*k};
		}
		int[] res = new int[k+1];
		for(int i=0;i<=k;i++) {
			res[i] = shorter*(k-i)+longer*i;
		}
		return res;
	}
	
}
