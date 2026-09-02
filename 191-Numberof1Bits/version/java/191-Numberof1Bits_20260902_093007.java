// Last updated: 9/2/2026, 9:30:07 AM
1class Solution {
2    public char findTheDifference(String s, String t) {
3        char result = 0;
4
5        for (char c : s.toCharArray()) {
6            result ^= c;
7        }
8
9        for (char c : t.toCharArray()) {
10            result ^= c;
11        }
12
13        return result;
14    }
15}