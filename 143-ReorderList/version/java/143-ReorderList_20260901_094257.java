// Last updated: 9/1/2026, 9:42:57 AM
1class Solution {
2    public int singleNumber(int[] nums) {
3        int result = 0;
4
5        for (int num : nums) {
6            result ^= num;
7        }
8
9        return result;
10    }
11}