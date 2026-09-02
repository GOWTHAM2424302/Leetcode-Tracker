// Last updated: 9/2/2026, 9:37:32 AM
1class Solution {
2    public boolean validPalindrome(String s) {
3        int left = 0;
4        int right = s.length() - 1;
5
6        while (left < right) {
7            if (s.charAt(left) != s.charAt(right)) {
8                return isPalindrome(s, left + 1, right)
9                        || isPalindrome(s, left, right - 1);
10            }
11
12            left++;
13            right--;
14        }
15
16        return true;
17    }
18
19    private boolean isPalindrome(String s, int left, int right) {
20        while (left < right) {
21            if (s.charAt(left) != s.charAt(right)) {
22                return false;
23            }
24
25            left++;
26            right--;
27        }
28
29        return true;
30    }
31}