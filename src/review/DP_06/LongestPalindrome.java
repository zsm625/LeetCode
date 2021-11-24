class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
    String res = "";

    for (int i = len - 1; i >= 0; i--) {
        for (int j = i; j < len; j++) {
            if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                dp[i][j] = true;
            }
            if (dp[i][j] && (j - i + 1) > res.length()) {
                res = s.substring(i, j + 1);
            }
        }
     }
       return res;
    }
}
