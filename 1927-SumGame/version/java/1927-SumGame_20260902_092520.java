// Last updated: 9/2/2026, 9:25:20 AM
1class Solution {
2    public boolean canReach(String s, int minJump, int maxJump) {
3        int n = s.length();
4        boolean[] dp = new boolean[n];
5        dp[0] = true;
6
7        int reachable = 0;
8
9        for (int i = 1; i < n; i++) {
10            if (i >= minJump && dp[i - minJump]) {
11                reachable++;
12            }
13
14            if (i > maxJump && dp[i - maxJump - 1]) {
15                reachable--;
16            }
17
18            dp[i] = reachable > 0 && s.charAt(i) == '0';
19        }
20
21        return dp[n - 1];
22    }
23}