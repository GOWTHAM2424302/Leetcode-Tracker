// Last updated: 8/5/2026, 11:38:43 AM
1import java.util.*;
2
3class Solution {
4    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
5        List<Integer>[] graph = new ArrayList[n];
6        for (int i = 0; i < n; i++) {
7            graph[i] = new ArrayList<>();
8        }
9
10        for (int[] edge : invocations) {
11            graph[edge[0]].add(edge[1]);
12        }
13
14        // Find all suspicious methods
15        boolean[] suspicious = new boolean[n];
16        Queue<Integer> queue = new LinkedList<>();
17        queue.offer(k);
18        suspicious[k] = true;
19
20        while (!queue.isEmpty()) {
21            int u = queue.poll();
22            for (int v : graph[u]) {
23                if (!suspicious[v]) {
24                    suspicious[v] = true;
25                    queue.offer(v);
26                }
27            }
28        }
29
30        // Check if any non-suspicious method invokes a suspicious method
31        for (int[] edge : invocations) {
32            int from = edge[0];
33            int to = edge[1];
34            if (!suspicious[from] && suspicious[to]) {
35                List<Integer> ans = new ArrayList<>();
36                for (int i = 0; i < n; i++) {
37                    ans.add(i);
38                }
39                return ans;
40            }
41        }
42
43        // Return remaining methods
44        List<Integer> ans = new ArrayList<>();
45        for (int i = 0; i < n; i++) {
46            if (!suspicious[i]) {
47                ans.add(i);
48            }
49        }
50
51        return ans;
52    }
53}