// Last updated: 7/17/2026, 9:35:37 AM
1class Solution {
2    public int countBinarySubstrings(String s) {
3        int prevGroup = 0;
4        int currGroup = 1;
5        int result = 0;
6
7        for (int i = 1; i < s.length(); i++) {
8            if (s.charAt(i) == s.charAt(i - 1)) {
9                currGroup++;
10            } else {
11                result += Math.min(prevGroup, currGroup);
12                prevGroup = currGroup;
13                currGroup = 1;
14            }
15        }
16
17        result += Math.min(prevGroup, currGroup);
18
19        return result;
20    }
21}