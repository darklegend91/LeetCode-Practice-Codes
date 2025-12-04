class Solution {
    int[][] dp;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];

        // Fill with -1 to mark “unseen lands”
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                dp[a][b] = -1;
            }
        }

        return helper(s, 0, n - 1);
    }

    int helper(String s, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + helper(s, i + 1, j - 1);
        } else {
            dp[i][j] = Math.max(
                helper(s, i + 1, j),
                helper(s, i, j - 1)
            );
        }

        return dp[i][j];
    }
}
