// Last updated: 9/1/2026, 9:46:25 AM
1import java.util.*;
2
3class Solution {
4    public boolean wordBreak(String s, List<String> wordDict) {
5        
6        Set<String> set = new HashSet<>(wordDict);
7        int n = s.length();
8
9        boolean[] dp = new boolean[n + 1];
10        dp[0] = true;
11
12        for (int i = 1; i <= n; i++) {
13            for (int j = 0; j < i; j++) {
14                
15                if (dp[j] && set.contains(s.substring(j, i))) {
16                    dp[i] = true;
17                    break;
18                }
19            }
20        }
21
22        return dp[n];
23    }
24}