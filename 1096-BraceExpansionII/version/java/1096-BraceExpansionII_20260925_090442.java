// Last updated: 9/25/2026, 9:04:42 AM
1import java.util.*;
2
3class Solution {
4    public List<String> braceExpansionII(String expression) {
5        Set<String> set = parse(expression, 0, expression.length() - 1);
6        List<String> ans = new ArrayList<>(set);
7        Collections.sort(ans);
8        return ans;
9    }
10
11    private Set<String> parse(String s, int l, int r) {
12        Set<String> result = new HashSet<>();
13        Set<String> current = new HashSet<>();
14        current.add("");
15
16        int i = l;
17
18        while (i <= r) {
19            Set<String> part;
20
21            if (s.charAt(i) == '{') {
22                int count = 1;
23                int j = i + 1;
24
25                while (count > 0) {
26                    if (s.charAt(j) == '{') {
27                        count++;
28                    } else if (s.charAt(j) == '}') {
29                        count--;
30                    }
31                    j++;
32                }
33
34                part = parseGroup(s, i + 1, j - 2);
35                i = j;
36            } else {
37                part = new HashSet<>();
38                part.add(String.valueOf(s.charAt(i)));
39                i++;
40            }
41
42            Set<String> next = new HashSet<>();
43
44            for (String a : current) {
45                for (String b : part) {
46                    next.add(a + b);
47                }
48            }
49
50            current = next;
51
52            if (i <= r && s.charAt(i) == ',') {
53                result.addAll(current);
54                current = new HashSet<>();
55                current.add("");
56                i++;
57            }
58        }
59
60        result.addAll(current);
61        return result;
62    }
63
64    private Set<String> parseGroup(String s, int l, int r) {
65        Set<String> result = new HashSet<>();
66        int start = l;
67        int depth = 0;
68
69        for (int i = l; i <= r; i++) {
70            char c = s.charAt(i);
71
72            if (c == '{') {
73                depth++;
74            } else if (c == '}') {
75                depth--;
76            } else if (c == ',' && depth == 0) {
77                result.addAll(parse(s, start, i - 1));
78                start = i + 1;
79            }
80        }
81
82        result.addAll(parse(s, start, r));
83        return result;
84    }
85}