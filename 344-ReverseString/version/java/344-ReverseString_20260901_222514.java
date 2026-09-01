// Last updated: 9/1/2026, 10:25:14 PM
1import java.util.*;
2
3class Solution {
4    public boolean isValid(String code) {
5        Stack<String> stack = new Stack<>();
6        int i = 0;
7        int n = code.length();
8
9        while (i < n) {
10
11            // CDATA section
12            if (code.startsWith("<![CDATA[", i)) {
13                if (stack.isEmpty()) return false;
14
15                int end = code.indexOf("]]>", i);
16
17                if (end == -1) return false;
18
19                i = end + 3;
20            }
21
22            // Closing tag
23            else if (code.startsWith("</", i)) {
24                int end = code.indexOf(">", i);
25
26                if (end == -1) return false;
27
28                String tag = code.substring(i + 2, end);
29
30                if (!isValidTag(tag)) return false;
31                if (stack.isEmpty() || !stack.pop().equals(tag)) {
32                    return false;
33                }
34
35                i = end + 1;
36
37                // Root tag must close at the end
38                if (stack.isEmpty() && i != n) {
39                    return false;
40                }
41            }
42
43            // Opening tag
44            else if (code.charAt(i) == '<') {
45                int end = code.indexOf(">", i);
46
47                if (end == -1) return false;
48
49                String tag = code.substring(i + 1, end);
50
51                if (!isValidTag(tag)) return false;
52
53                stack.push(tag);
54                i = end + 1;
55            }
56
57            // Normal characters
58            else {
59                if (stack.isEmpty()) return false;
60                i++;
61            }
62        }
63
64        return stack.isEmpty();
65    }
66
67    private boolean isValidTag(String tag) {
68        if (tag.length() < 1 || tag.length() > 9) {
69            return false;
70        }
71
72        for (char ch : tag.toCharArray()) {
73            if (ch < 'A' || ch > 'Z') {
74                return false;
75            }
76        }
77
78        return true;
79    }
80}