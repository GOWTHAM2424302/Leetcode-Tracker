// Last updated: 9/8/2026, 10:27:14 AM
1class Solution {
2    private static final int MOD = 1_000_000_007;
3
4    public int numDecodings(String s) {
5        long prev2 = 1; // dp[i - 2]
6        long prev1 = waysOne(s.charAt(0)); // dp[i - 1]
7
8        for (int i = 1; i < s.length(); i++) {
9            long current = (prev1 * waysOne(s.charAt(i))) % MOD;
10
11            current = (current
12                    + prev2 * waysTwo(s.charAt(i - 1), s.charAt(i))) % MOD;
13
14            prev2 = prev1;
15            prev1 = current;
16        }
17
18        return (int) prev1;
19    }
20
21    // Ways to decode one character
22    private int waysOne(char c) {
23        if (c == '*') return 9;
24        if (c == '0') return 0;
25        return 1;
26    }
27
28    // Ways to decode two characters
29    private int waysTwo(char a, char b) {
30        if (a == '*' && b == '*') {
31            return 15; // 11-19 and 21-26
32        }
33
34        if (a == '*') {
35            if (b >= '0' && b <= '6') return 2; // 10/20 to 16/26
36            return 1; // 17-19
37        }
38
39        if (b == '*') {
40            if (a == '1') return 9; // 11-19
41            if (a == '2') return 6; // 21-26
42            return 0;
43        }
44
45        int num = (a - '0') * 10 + (b - '0');
46
47        return num >= 10 && num <= 26 ? 1 : 0;
48    }
49}