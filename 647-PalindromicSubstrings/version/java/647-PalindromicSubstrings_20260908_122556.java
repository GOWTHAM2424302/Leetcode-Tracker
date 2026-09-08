// Last updated: 9/8/2026, 12:25:56 PM
1class Solution {
2    public boolean isPowerOfFour(int n) {
3        if (n <= 0) {
4            return false;
5        }
6
7        while (n % 4 == 0) {
8            n /= 4;
9        }
10
11        return n == 1;
12    }
13}