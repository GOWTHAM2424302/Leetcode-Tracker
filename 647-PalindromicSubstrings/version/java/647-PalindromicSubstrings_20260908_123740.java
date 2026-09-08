// Last updated: 9/8/2026, 12:37:40 PM
1class Solution {
2    public String decodeString(String s) {
3        java.util.Stack<Integer> counts = new java.util.Stack<>();
4        java.util.Stack<StringBuilder> strings = new java.util.Stack<>();
5
6        StringBuilder current = new StringBuilder();
7        int number = 0;
8
9        for (char ch : s.toCharArray()) {
10            if (Character.isDigit(ch)) {
11                number = number * 10 + (ch - '0');
12            } else if (ch == '[') {
13                counts.push(number);
14                strings.push(current);
15                number = 0;
16                current = new StringBuilder();
17            } else if (ch == ']') {
18                StringBuilder previous = strings.pop();
19                int repeat = counts.pop();
20
21                for (int i = 0; i < repeat; i++) {
22                    previous.append(current);
23                }
24
25                current = previous;
26            } else {
27                current.append(ch);
28            }
29        }
30
31        return current.toString();
32    }
33}