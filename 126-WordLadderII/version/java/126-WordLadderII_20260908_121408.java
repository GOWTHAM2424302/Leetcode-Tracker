// Last updated: 9/8/2026, 12:14:08 PM
1import java.util.*;
2
3class Solution {
4    public String removeDuplicateLetters(String s) {
5        int[] lastIndex = new int[26];
6
7        for (int i = 0; i < s.length(); i++) {
8            lastIndex[s.charAt(i) - 'a'] = i;
9        }
10
11        boolean[] used = new boolean[26];
12        Stack<Character> stack = new Stack<>();
13
14        for (int i = 0; i < s.length(); i++) {
15            char ch = s.charAt(i);
16
17            if (used[ch - 'a']) {
18                continue;
19            }
20
21            while (!stack.isEmpty()
22                    && stack.peek() > ch
23                    && lastIndex[stack.peek() - 'a'] > i) {
24
25                used[stack.pop() - 'a'] = false;
26            }
27
28            stack.push(ch);
29            used[ch - 'a'] = true;
30        }
31
32        StringBuilder result = new StringBuilder();
33
34        for (char ch : stack) {
35            result.append(ch);
36        }
37
38        return result.toString();
39    }
40}