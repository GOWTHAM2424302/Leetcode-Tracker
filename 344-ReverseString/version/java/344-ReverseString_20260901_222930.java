// Last updated: 9/1/2026, 10:29:30 PM
1import java.util.*;
2
3class Solution {
4    public boolean judgePoint24(int[] cards) {
5        List<Double> nums = new ArrayList<>();
6
7        for (int card : cards) {
8            nums.add((double) card);
9        }
10
11        return solve(nums);
12    }
13
14    private boolean solve(List<Double> nums) {
15        if (nums.size() == 1) {
16            return Math.abs(nums.get(0) - 24.0) < 0.000001;
17        }
18
19        for (int i = 0; i < nums.size(); i++) {
20            for (int j = i + 1; j < nums.size(); j++) {
21
22                List<Double> next = new ArrayList<>();
23
24                // Add remaining numbers
25                for (int k = 0; k < nums.size(); k++) {
26                    if (k != i && k != j) {
27                        next.add(nums.get(k));
28                    }
29                }
30
31                double a = nums.get(i);
32                double b = nums.get(j);
33
34                List<Double> values = new ArrayList<>();
35
36                values.add(a + b);
37                values.add(a - b);
38                values.add(b - a);
39                values.add(a * b);
40
41                if (Math.abs(b) > 0.000001) {
42                    values.add(a / b);
43                }
44
45                if (Math.abs(a) > 0.000001) {
46                    values.add(b / a);
47                }
48
49                // Try every possible result
50                for (double value : values) {
51                    next.add(value);
52
53                    if (solve(next)) {
54                        return true;
55                    }
56
57                    next.remove(next.size() - 1);
58                }
59            }
60        }
61
62        return false;
63    }
64}