// Last updated: 9/16/2026, 1:59:00 PM
1class Solution {
2    public int largestOverlap(int[][] img1, int[][] img2) {
3        int n = img1.length;
4        int ans = 0;
5
6        for (int r = -n + 1; r < n; r++) {
7            for (int c = -n + 1; c < n; c++) {
8                int count = 0;
9
10                for (int i = 0; i < n; i++) {
11                    for (int j = 0; j < n; j++) {
12                        int x = i + r;
13                        int y = j + c;
14
15                        if (x >= 0 && x < n && y >= 0 && y < n &&
16                            img1[i][j] == 1 && img2[x][y] == 1) {
17                            count++;
18                        }
19                    }
20                }
21
22                ans = Math.max(ans, count);
23            }
24        }
25
26        return ans;
27    }
28}