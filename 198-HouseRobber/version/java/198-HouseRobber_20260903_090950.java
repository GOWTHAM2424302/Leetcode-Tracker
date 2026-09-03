// Last updated: 9/3/2026, 9:09:50 AM
1class Solution {
2    public int rob(int[] nums) {
3        int prev2 = 0;
4        int prev1 = 0;
5
6        for (int num : nums) {
7            int current = Math.max(prev1, prev2 + num);
8            prev2 = prev1;
9            prev1 = current;
10        }
11
12        return prev1;
13    }
14}
15