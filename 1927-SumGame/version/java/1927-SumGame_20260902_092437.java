// Last updated: 9/2/2026, 9:24:37 AM
1class Solution {
2    public int maxJumps(int[] arr, int d) {
3        int n = arr.length;
4        int[] dp = new int[n];
5
6        int answer = 1;
7
8        for (int i = 0; i < n; i++) {
9            answer = Math.max(answer, dfs(i, arr, d, dp));
10        }
11
12        return answer;
13    }
14
15    private int dfs(int i, int[] arr, int d, int[] dp) {
16        if (dp[i] != 0) {
17            return dp[i];
18        }
19
20        int max = 1;
21
22        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
23            if (arr[j] >= arr[i]) {
24                break;
25            }
26
27            max = Math.max(max, 1 + dfs(j, arr, d, dp));
28        }
29
30        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {
31            if (arr[j] >= arr[i]) {
32                break;
33            }
34
35            max = Math.max(max, 1 + dfs(j, arr, d, dp));
36        }
37
38        return dp[i] = max;
39    }
40}