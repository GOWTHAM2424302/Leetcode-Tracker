// Last updated: 9/2/2026, 9:24:04 AM
1class Solution {
2    public boolean sumGame(String num) {
3        int n = num.length();
4        int leftSum = 0;
5        int rightSum = 0;
6        int leftQuestion = 0;
7        int rightQuestion = 0;
8
9        for (int i = 0; i < n; i++) {
10            char c = num.charAt(i);
11
12            if (i < n / 2) {
13                if (c == '?') {
14                    leftQuestion++;
15                } else {
16                    leftSum += c - '0';
17                }
18            } else {
19                if (c == '?') {
20                    rightQuestion++;
21                } else {
22                    rightSum += c - '0';
23                }
24            }
25        }
26
27        // Alice wins if total '?' count is odd
28        if ((leftQuestion + rightQuestion) % 2 == 1) {
29            return true;
30        }
31
32        // Difference that Bob can compensate
33        int sumDiff = leftSum - rightSum;
34        int questionDiff = rightQuestion - leftQuestion;
35
36        return 2 * sumDiff != 9 * questionDiff;
37    }
38}