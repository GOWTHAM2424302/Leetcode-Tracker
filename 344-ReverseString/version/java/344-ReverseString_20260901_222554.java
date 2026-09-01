// Last updated: 9/1/2026, 10:25:54 PM
1import java.util.*;
2
3class Solution {
4    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
5        int[] distances = {
6            distance(p1, p2),
7            distance(p1, p3),
8            distance(p1, p4),
9            distance(p2, p3),
10            distance(p2, p4),
11            distance(p3, p4)
12        };
13
14        Arrays.sort(distances);
15
16        // First 4 distances = sides
17        // Last 2 distances = diagonals
18        return distances[0] > 0 &&
19               distances[0] == distances[1] &&
20               distances[1] == distances[2] &&
21               distances[2] == distances[3] &&
22               distances[4] == distances[5] &&
23               distances[4] == 2 * distances[0];
24    }
25
26    private int distance(int[] a, int[] b) {
27        int x = a[0] - b[0];
28        int y = a[1] - b[1];
29
30        return x * x + y * y;
31    }
32}