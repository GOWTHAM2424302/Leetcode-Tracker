// Last updated: 9/1/2026, 10:22:07 AM
1class Solution {
2    public String reverseStr(String s, int k) {
3        char[] arr = s.toCharArray();
4
5        for (int i = 0; i < arr.length; i += 2 * k) {
6            int left = i;
7            int right = Math.min(i + k - 1, arr.length - 1);
8
9            while (left < right) {
10                char temp = arr[left];
11                arr[left] = arr[right];
12                arr[right] = temp;
13
14                left++;
15                right--;
16            }
17        }
18
19        return new String(arr);
20    }
21}