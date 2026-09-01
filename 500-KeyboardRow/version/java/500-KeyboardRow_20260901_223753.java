// Last updated: 9/1/2026, 10:37:53 PM
1class Solution {
2    public boolean rotateString(String s, String goal) {
3        if (s.length() != goal.length()) {
4            return false;
5        }
6
7        return (s + s).contains(goal);
8    }
9}