class MinDistance {
    public int minDistance(String word1, String word2) {
        // 操作可分为四种
        //1、如果s1[i]==s2[j] 可跳过不做处理
        //2、如果s1[i]!=s2[j] 有三种操作可做
        //  1、删除 2、插入 3、替换
        int m = word1.length(), n = word2.length();
    // 定义：s1[0..i] 和 s2[0..j] 的最小编辑距离是 dp[i-1][j-1]
    int[][] dp = new int[m + 1][n + 1];
    // base case 
    for (int i = 1; i <= m; i++)
        dp[i][0] = i;
    for (int j = 1; j <= n; j++)
        dp[0][j] = j;
    // 自底向上求解
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i-1) == word2.charAt(j-1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = min(
                    dp[i - 1][j] + 1,
                    dp[i][j - 1] + 1,
                    dp[i - 1][j - 1] + 1
                );
            }
        }
    }
    // 储存着整个 s1 和 s2 的最小编辑距离
    return dp[m][n];
}

int min(int a, int b, int c) {
    return Math.min(a, Math.min(b, c));
}
}
