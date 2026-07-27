// Last updated: 7/27/2026, 2:49:10 PM
1class Solution {
2    public int maxProduct(int[] nums) {
3        int max1 = 0;
4        int max2 = 0;
5
6        for (int num : nums) {
7            if (num > max1) {
8                max2 = max1;
9                max1 = num;
10            } else if (num > max2) {
11                max2 = num;
12            }
13        }
14
15        return (max1 - 1) * (max2 - 1);
16    }
17}
18