// Last updated: 9/8/2026, 12:25:13 PM
1class Solution {
2    public int[] countBits(int n) {
3        int[] result = new int[n + 1];
4
5        for (int i = 1; i <= n; i++) {
6            result[i] = result[i / 2] + (i % 2);
7        }
8
9        return result;
10    }
11}