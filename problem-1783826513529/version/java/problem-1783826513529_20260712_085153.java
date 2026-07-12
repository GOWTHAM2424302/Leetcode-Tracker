// Last updated: 7/12/2026, 8:51:53 AM
1class Solution {
2    public int maxConsistentColumns(int[][] grid, int limit) {
3        int[][] canovireth = grid;
4        int m = canovireth.length;
5        int n = canovireth[0].length;
6        int[] dp = new int[n];
7        int answer = 1;
8        for (int j = 0; j < n; j++) {
9            dp[j] = 1;
10            for (int prev = 0; prev < j; prev++) {
11                boolean valid = true;
12                for (int row = 0; row < m; row++) {
13                    if (Math.abs(canovireth[row][j] - canovireth[row][prev]) > limit) {
14                        valid = false;
15                        break;
16                    }
17                }
18                if (valid) {
19                    dp[j] = Math.max(dp[j], dp[prev] + 1);
20                }
21            }
22            answer = Math.max(answer, dp[j]);
23        }
24        return answer;
25    }
26}