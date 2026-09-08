// Last updated: 9/8/2026, 10:13:43 AM
1class Solution {
2    public int countCommas(int n) {
3        int count = 0;
4
5        for (int i = 1; i <= n; i++) {
6            int digits = String.valueOf(i).length();
7            count += (digits - 1) / 3;
8        }
9
10        return count;
11    }
12}