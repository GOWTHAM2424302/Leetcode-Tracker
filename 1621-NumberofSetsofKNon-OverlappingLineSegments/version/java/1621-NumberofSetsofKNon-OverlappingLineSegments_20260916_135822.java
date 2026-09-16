// Last updated: 9/16/2026, 1:58:22 PM
1class Solution {
2    public int numberOfSets(int n, int k) {
3        int MOD = 1000000007;
4        int limit = n + k - 1;
5
6        long[] dp = new long[2 * k + 1];
7        dp[0] = 1;
8
9        for (int i = 1; i <= limit; i++) {
10            for (int j = Math.min(i, 2 * k); j >= 1; j--) {
11                dp[j] = (dp[j] + dp[j - 1]) % MOD;
12            }
13        }
14
15        return (int) dp[2 * k];
16    }
17}
18