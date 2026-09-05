class Solution {
    public boolean isSubsequence(String s, String t) {

        int m = s.length();
        int n = t.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string is a subsequence of any string
        for (int j = 0; j <= n; j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}