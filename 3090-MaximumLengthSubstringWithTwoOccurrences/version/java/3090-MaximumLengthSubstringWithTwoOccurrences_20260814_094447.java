// Last updated: 8/14/2026, 9:44:47 AM
1class Solution {
2    public int maximumLengthSubstring(String s) {
3        Map<Character, Integer> count = new HashMap<>();
4        int i = 0, res = 0;
5        for (int j = 0; j < s.length(); j++) {
6            char c = s.charAt(j);
7            count.put(c, count.getOrDefault(c, 0) + 1);
8            while (count.get(c) > 2) {
9                char left = s.charAt(i);
10                count.put(left, count.get(left) - 1);
11                i++;
12            }
13            res = Math.max(res, j - i + 1);
14        }
15        return res;
16    }
17}