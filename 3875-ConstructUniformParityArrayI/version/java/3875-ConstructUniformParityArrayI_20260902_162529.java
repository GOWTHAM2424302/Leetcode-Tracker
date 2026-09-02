// Last updated: 9/2/2026, 4:25:29 PM
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int n = nums1.length;
4        int odd = 0;
5        int even = 0;
6
7        for (int num : nums1) {
8            if (num % 2 == 0) {
9                even++;
10            } else {
11                odd++;
12            }
13        }
14
15        return odd == 0 || even == 0 || (odd > 0 && even > 0);
16    }
17}