// Last updated: 7/17/2026, 9:28:34 AM
1import java.util.*;
2
3class Solution {
4    public long gcdSum(int[] nums) {
5        int n = nums.length;
6        int[] prefixGcd = new int[n];
7
8        int mx = 0;
9        for (int i = 0; i < n; i++) {
10            mx = Math.max(mx, nums[i]);
11            prefixGcd[i] = gcd(nums[i], mx);
12        }
13
14        Arrays.sort(prefixGcd);
15
16        long sum = 0;
17        int left = 0, right = n - 1;
18
19        while (left < right) {
20            sum += gcd(prefixGcd[left], prefixGcd[right]);
21            left++;
22            right--;
23        }
24
25        return sum;
26    }
27
28    private int gcd(int a, int b) {
29        while (b != 0) {
30            int temp = b;
31            b = a % b;
32            a = temp;
33        }
34        return a;
35    }
36}