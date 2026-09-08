// Last updated: 9/8/2026, 10:30:25 AM
1class Solution {
2    public int longestMountain(int[] arr) {
3        int n = arr.length;
4        int maxLength = 0;
5        int i = 1;
6
7        while (i < n - 1) {
8
9            // Check if arr[i] is a peak
10            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
11
12                int left = i;
13                int right = i;
14
15                // Expand to the left
16                while (left > 0 && arr[left - 1] < arr[left]) {
17                    left--;
18                }
19
20                // Expand to the right
21                while (right < n - 1 && arr[right] > arr[right + 1]) {
22                    right++;
23                }
24
25                maxLength = Math.max(maxLength, right - left + 1);
26
27                // Skip processed elements
28                i = right;
29            }
30
31            i++;
32        }
33
34        return maxLength;
35    }
36}