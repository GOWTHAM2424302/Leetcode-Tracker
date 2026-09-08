// Last updated: 9/8/2026, 10:25:09 AM
1import java.util.*;
2
3class Solution {
4    private int index = 0;
5
6    public NestedInteger deserialize(String s) {
7        if (s.charAt(0) != '[') {
8            return new NestedInteger(Integer.parseInt(s));
9        }
10
11        return parse(s);
12    }
13
14    private NestedInteger parse(String s) {
15        NestedInteger result = new NestedInteger();
16        index++; // Skip '['
17
18        while (s.charAt(index) != ']') {
19
20            if (s.charAt(index) == '[') {
21                result.add(parse(s));
22            } else {
23                int sign = 1;
24
25                if (s.charAt(index) == '-') {
26                    sign = -1;
27                    index++;
28                }
29
30                int num = 0;
31
32                while (index < s.length()
33                        && Character.isDigit(s.charAt(index))) {
34                    num = num * 10 + (s.charAt(index) - '0');
35                    index++;
36                }
37
38                result.add(new NestedInteger(sign * num));
39            }
40
41            // Skip comma
42            if (s.charAt(index) == ',') {
43                index++;
44            }
45        }
46
47        index++; // Skip ']'
48        return result;
49    }
50}