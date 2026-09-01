// Last updated: 9/1/2026, 10:23:40 PM
1class Solution {
2    public int missingNumber(int[] nums) {
3        int n = nums.length;
4        int xor = n;
5
6        for (int i = 0; i < n; i++) {
7            xor ^= i;
8            xor ^= nums[i];
9        }
10
11        return xor;
12    }
13}