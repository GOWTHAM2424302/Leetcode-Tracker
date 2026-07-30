// Last updated: 7/30/2026, 9:19:43 AM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length;
4
5        if (n <= 2) {
6            return n;
7        }
8
9        int bits = 32 - Integer.numberOfLeadingZeros(n);
10        return 1 << bits;
11    }
12}