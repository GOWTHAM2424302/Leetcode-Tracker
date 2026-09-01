// Last updated: 9/1/2026, 10:32:57 PM
1class Solution {
2    public int findMaxForm(String[] strs, int m, int n) {
3        int[][] dp = new int[m + 1][n + 1];
4
5        for (String str : strs) {
6            int zeros = 0;
7            int ones = 0;
8
9            for (char c : str.toCharArray()) {
10                if (c == '0') {
11                    zeros++;
12                } else {
13                    ones++;
14                }
15            }
16
17            // Traverse backwards to avoid using the same string multiple times
18            for (int i = m; i >= zeros; i--) {
19                for (int j = n; j >= ones; j--) {
20                    dp[i][j] = Math.max(
21                        dp[i][j],
22                        dp[i - zeros][j - ones] + 1
23                    );
24                }
25            }
26        }
27
28        return dp[m][n];
29    }
30}