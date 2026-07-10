// Last updated: 7/10/2026, 9:07:58 AM
1import java.util.*;
2
3class Solution {
4    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
5        int[][] arr = new int[n][2];
6
7        for (int i = 0; i < n; i++) {
8            arr[i][0] = nums[i];
9            arr[i][1] = i;
10        }
11
12        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
13
14        int[] pos = new int[n];
15        int[] values = new int[n];
16
17        for (int i = 0; i < n; i++) {
18            values[i] = arr[i][0];
19            pos[arr[i][1]] = i;
20        }
21
22        int[] comp = new int[n];
23        int cid = 0;
24
25        for (int i = 1; i < n; i++) {
26            if (values[i] - values[i - 1] > maxDiff) {
27                cid++;
28            }
29            comp[i] = cid;
30        }
31
32        int[] reach = new int[n];
33        int j = 0;
34
35        for (int i = 0; i < n; i++) {
36            while (j + 1 < n && values[j + 1] - values[i] <= maxDiff) {
37                j++;
38            }
39            reach[i] = j;
40        }
41
42        int LOG = 18;
43        int[][] up = new int[LOG][n];
44        up[0] = reach.clone();
45
46        for (int k = 1; k < LOG; k++) {
47            for (int i = 0; i < n; i++) {
48                up[k][i] = up[k - 1][up[k - 1][i]];
49            }
50        }
51
52        int[] ans = new int[queries.length];
53
54        for (int q = 0; q < queries.length; q++) {
55            int u = pos[queries[q][0]];
56            int v = pos[queries[q][1]];
57
58            if (u == v) {
59                ans[q] = 0;
60                continue;
61            }
62
63            if (u > v) {
64                int temp = u;
65                u = v;
66                v = temp;
67            }
68
69            if (comp[u] != comp[v]) {
70                ans[q] = -1;
71                continue;
72            }
73
74            int steps = 0;
75            int cur = u;
76
77            for (int k = LOG - 1; k >= 0; k--) {
78                if (up[k][cur] < v && up[k][cur] > cur) {
79                    steps += (1 << k);
80                    cur = up[k][cur];
81                }
82            }
83
84            ans[q] = steps + 1;
85        }
86
87        return ans;
88    }
89}