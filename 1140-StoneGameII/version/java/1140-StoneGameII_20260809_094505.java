// Last updated: 8/9/2026, 9:45:05 AM
1class Solution {
2    private int[][] dp;
3    private int n;
4
5    public int stoneGameII(int[] piles) {
6        n = piles.length;
7        dp = new int[n][n + 1];
8        
9        for (int i = n - 2; i >= 0; i--) {
10            piles[i] += piles[i + 1];
11        }
12        
13        return dfs(piles, 0, 1);
14    }
15
16    private int dfs(int[] piles, int i, int m) {
17        if (i + 2 * m >= n) return piles[i];
18        if (dp[i][m] != 0) return dp[i][m];
19
20        int minopp = Integer.MAX_VALUE;
21        for (int x = 1; x <= 2 * m; x++) {
22            minopp = Math.min(minopp, dfs(piles, i + x, Math.max(m, x)));
23        }
24
25        return dp[i][m] = piles[i] - minopp;
26    }
27}