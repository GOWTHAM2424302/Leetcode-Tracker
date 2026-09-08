// Last updated: 9/8/2026, 10:29:18 AM
1class Solution {
2    public double soupServings(int n) {
3        // For large n, probability approaches 1
4        if (n >= 5000) {
5            return 1.0;
6        }
7
8        int units = (n + 24) / 25;
9        Double[][] memo = new Double[units + 1][units + 1];
10
11        return dfs(units, units, memo);
12    }
13
14    private double dfs(int a, int b, Double[][] memo) {
15        // A and B become empty at the same time
16        if (a <= 0 && b <= 0) {
17            return 0.5;
18        }
19
20        // A becomes empty first
21        if (a <= 0) {
22            return 1.0;
23        }
24
25        // B becomes empty first
26        if (b <= 0) {
27            return 0.0;
28        }
29
30        if (memo[a][b] != null) {
31            return memo[a][b];
32        }
33
34        memo[a][b] = 0.25 * (
35            dfs(a - 4, b, memo) +
36            dfs(a - 3, b - 1, memo) +
37            dfs(a - 2, b - 2, memo) +
38            dfs(a - 1, b - 3, memo)
39        );
40
41        return memo[a][b];
42    }
43}
44