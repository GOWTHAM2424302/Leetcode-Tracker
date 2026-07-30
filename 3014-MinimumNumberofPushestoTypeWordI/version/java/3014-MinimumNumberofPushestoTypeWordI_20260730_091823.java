// Last updated: 7/30/2026, 9:18:23 AM
1class Solution {
2    public int minimumPushes(String word) {
3        int n = word.length();
4        int ans = 0;
5
6        for (int i = 0; i < n; i++) {
7            ans += (i / 8) + 1;
8        }
9
10        return ans;
11    }
12}