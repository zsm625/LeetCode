package office66;

/**
 * 新21点
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 
 * 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，
 * 其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 
 * 爱丽丝的分数不超过 N 的概率是多少？
 * 如输入：N = 10, K = 1, W = 10 | N = 6, K = 1, W = 10
 * 输出：1.0000                 |  0.6000
 * @author ZSM
 *
 * @time 2020年6月3日上午10:51:31
 */
public class New21Game {

	/**
	 * 脑袋嗡嗡的。。。
	 * 采用的动态规划、反序求解
	 * 数学知识的重要性！！！
	 *@author ZSM
	 * @param N
	 * @param K
	 * @param W
	 * @return
	 */
	public double new21Game(int N,int K,int W) {
		if(K==0) {
			return 1.0;
		}
		double[] dp = new double[K+W];
		for(int i=K;i<=N && i<K+W;i++) {
			dp[i] = 1.0;
		}
		dp[K-1] = 1.0*Math.min(N-K+1, W)/W;
		for(int i=K-2;i>=0;i--) {
			dp[i] = dp[i+1]-(dp[i+W+1]-dp[i+1])/W;
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		New21Game game = new New21Game();
		double d = game.new21Game(21, 17, 10);
		System.out.println(d);
	}
}
