// Last updated: 7/18/2026, 9:52:07 AM
1class Solution {
2    public int findGCD(int[] nums) {
3        int min = nums[0];
4        int max = nums[0];
5        
6        for (int num : nums) {
7            if (num < min) min = num;
8            if (num > max) max = num;
9        }
10        
11        return gcd(min, max);
12    }
13    
14    private int gcd(int a, int b) {
15        while (b != 0) {
16            int temp = b;
17            b = a % b;
18            a = temp;
19        }
20        return a;
21    }
22}
23