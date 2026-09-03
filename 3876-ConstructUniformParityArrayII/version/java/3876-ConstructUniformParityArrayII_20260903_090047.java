// Last updated: 9/3/2026, 9:00:47 AM
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int min = Integer.MAX_VALUE;
4        boolean hasOdd = false;
5        boolean hasEven = false;
6
7        for (int num : nums1) {
8            min = Math.min(min, num);
9
10            if (num % 2 == 0) {
11                hasEven = true;
12            } else {
13                hasOdd = true;
14            }
15        }
16
17        if (!hasOdd || !hasEven) {
18            return true;
19        }
20
21        return min % 2 == 1;
22    }
23}