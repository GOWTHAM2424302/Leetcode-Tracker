// Last updated: 8/9/2026, 9:42:25 AM
1class Solution {
2    public int stoneGameII(int[] piles) {
3        int n = piles.length;
4        int[] suffixSum = new int[n + 1];        
5        for (int i = n - 1; i >= 0; i--) {
6            suffixSum[i] = suffixSum[i + 1] + piles[i];
7        }
8        Integer[][] memo = new Integer[n][n + 1];
9                return dfs(0, 1, piles, suffixSum, memo);
10    }
11        private int dfs(int i, int M, int[] piles, int[] suffixSum, Integer[][] memo) {
12        int n = piles.length;
13        if (i >= n) return 0;
14            if (2 * M >= n - i) {
15            return suffixSum[i];
16        }
17                if (memo[i][M] != null) return memo[i][M];
18        
19        int best = 0;
20        for (int X = 1; X <= 2 * M; X++) {
21            int opponent = dfs(i + X, Math.max(M, X), piles, suffixSum, memo);
22            best = Math.max(best, suffixSum[i] - opponent);
23        }
24                memo[i][M] = best;
25        return best;
26    }
27}