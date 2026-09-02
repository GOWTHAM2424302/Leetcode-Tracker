// Last updated: 9/2/2026, 9:29:16 AM
1class Solution {
2    public int hammingWeight(int n) {
3        int count = 0;
4
5        while (n != 0) {
6            count++;
7            n = n & (n - 1);
8        }
9
10        return count;
11    }
12}