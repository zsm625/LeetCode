package office66;

/**
 * 除数博弈
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。
 * 爱丽丝先手开局。最初，黑板上有一个数字 N 。
 * 在每个玩家的回合，玩家需要执行以下操作：
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。
 * 假设两个玩家都以最佳状态参与游戏。
 * @author ZSM
 *
 * @time 2020年7月24日上午7:48:32
 */
public class DivisorGame {

	/**
	 * 找规律
	 * N-->(0,1) 找不到满足要求的整数，return false
	 * N-->(0,2) 当x=1时，AL win return true
	 * N-->(0,3) x=1当x=1时，最终回合是Bob，so AL lose 
	 * N-->(0,4) x=1,2 当x=1(A)时，N-->3,x=1(B), N -->2,x=1(A) 最终AL win
	 * N-->(0,5) x=1,最终A lose
	 * 由此规律可知，当N为偶数时，AL能赢，当N为奇数时，B能赢
	 *@author ZSM
	 * @param N
	 * @return
	 */
	public boolean divisorGame(int N) {
		if(N<=1) {
			return false;
		}
		return N % 2 ==0;
		
	}
}
