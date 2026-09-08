// Last updated: 9/8/2026, 12:39:37 PM
1class Solution {
2    public String toHex(int num) {
3        if (num == 0) {
4            return "0";
5        }
6
7        char[] hex = "0123456789abcdef".toCharArray();
8        StringBuilder result = new StringBuilder();
9
10        while (num != 0) {
11            result.append(hex[num & 15]);
12            num >>>= 4;
13        }
14
15        return result.reverse().toString();
16    }
17}