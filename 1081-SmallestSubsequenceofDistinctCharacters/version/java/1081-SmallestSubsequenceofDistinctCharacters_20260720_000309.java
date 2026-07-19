// Last updated: 7/20/2026, 12:03:09 AM
1class Solution {
2    public String smallestSubsequence(String s) {
3        int[] last = new int[26];
4        for (int i = 0; i < s.length(); i++) {
5            last[s.charAt(i) - 'a'] = i;
6        }
7
8        boolean[] used = new boolean[26];
9        StringBuilder stack = new StringBuilder();
10
11        for (int i = 0; i < s.length(); i++) {
12            char c = s.charAt(i);
13
14            if (used[c - 'a']) continue;
15
16            while (stack.length() > 0 &&
17                   stack.charAt(stack.length() - 1) > c &&
18                   last[stack.charAt(stack.length() - 1) - 'a'] > i) {
19                used[stack.charAt(stack.length() - 1) - 'a'] = false;
20                stack.deleteCharAt(stack.length() - 1);
21            }
22
23            stack.append(c);
24            used[c - 'a'] = true;
25        }
26
27        return stack.toString();
28    }
29}