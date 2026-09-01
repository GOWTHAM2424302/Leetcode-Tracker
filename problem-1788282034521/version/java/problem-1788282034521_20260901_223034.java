// Last updated: 9/1/2026, 10:30:34 PM
1class Solution {
2    public int maxRotateFunction(int[] nums) {
3        int n = nums.length;
4
5        long sum = 0;
6        long current = 0;
7
8        // Calculate sum and F(0)
9        for (int i = 0; i < n; i++) {
10            sum += nums[i];
11            current += (long) i * nums[i];
12        }
13
14        long max = current;
15
16        // Calculate F(k) using the previous value
17        for (int k = 1; k < n; k++) {
18            current = current + sum - (long) n * nums[n - k];
19            max = Math.max(max, current);
20        }
21
22        return (int) max;
23    }
24}