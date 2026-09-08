// Last updated: 9/8/2026, 10:28:39 AM
1class Solution {
2    public int rotatedDigits(int n) {
3        int count = 0;
4
5        for (int i = 1; i <= n; i++) {
6            if (isGood(i)) {
7                count++;
8            }
9        }
10
11        return count;
12    }
13
14    private boolean isGood(int num) {
15        boolean changed = false;
16
17        while (num > 0) {
18            int digit = num % 10;
19
20            // Invalid digits after rotation
21            if (digit == 3 || digit == 4 || digit == 7) {
22                return false;
23            }
24
25            // Digits that change after rotation
26            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
27                changed = true;
28            }
29
30            num /= 10;
31        }
32
33        return changed;
34    }
35}