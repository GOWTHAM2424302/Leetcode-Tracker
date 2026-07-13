// Last updated: 7/13/2026, 12:27:59 PM
1class Solution {
2    public int numDecodings(String s) {
3        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
4            return 0;
5        }
6
7        int n = s.length();
8        int[] dp = new int[n + 1];
9
10        dp[0] = 1;
11        dp[1] = 1;
12
13        for (int i = 2; i <= n; i++) {
14            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
15            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
16
17            if (oneDigit >= 1) {
18                dp[i] += dp[i - 1];
19            }
20
21            if (twoDigits >= 10 && twoDigits <= 26) {
22                dp[i] += dp[i - 2];
23            }
24        }
25
26        return dp[n];
27    }
28}
29