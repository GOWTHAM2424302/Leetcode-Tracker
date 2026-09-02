// Last updated: 9/2/2026, 9:32:57 AM
1class Solution {
2    public String convertToBase7(int num) {
3        if (num == 0) {
4            return "0";
5        }
6
7        boolean negative = num < 0;
8        num = Math.abs(num);
9
10        StringBuilder result = new StringBuilder();
11
12        while (num > 0) {
13            result.append(num % 7);
14            num /= 7;
15        }
16
17        if (negative) {
18            result.append("-");
19        }
20
21        return result.reverse().toString();
22    }
23}