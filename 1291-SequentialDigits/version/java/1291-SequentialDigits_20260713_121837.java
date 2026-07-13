// Last updated: 7/13/2026, 12:18:37 PM
1class Solution {
2    public List<Integer> sequentialDigits(int low, int high) {
3        List<Integer> result = new ArrayList<>();
4        String digits = "123456789";
5
6        int lowLen = String.valueOf(low).length();
7        int highLen = String.valueOf(high).length();
8
9        for (int len = lowLen; len <= highLen; len++) {
10            for (int start = 0; start + len <= 9; start++) {
11                int num = Integer.parseInt(digits.substring(start, start + len));
12
13                if (num >= low && num <= high) {
14                    result.add(num);
15                }
16            }
17        }
18
19        return result;
20    }
21}