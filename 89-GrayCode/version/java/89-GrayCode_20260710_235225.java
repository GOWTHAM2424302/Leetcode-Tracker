// Last updated: 7/10/2026, 11:52:25 PM
1class Solution {
2    public int numTrees(int n) {
3        int[] dp = new int[n + 1];
4
5        dp[0] = 1;
6        dp[1] = 1;
7
8        for (int nodes = 2; nodes <= n; nodes++) {
9            for (int root = 1; root <= nodes; root++) {
10                dp[nodes] += dp[root - 1] * dp[nodes - root];
11            }
12        }
13
14        return dp[n];
15    }
16}