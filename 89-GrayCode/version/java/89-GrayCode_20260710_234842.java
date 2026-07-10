// Last updated: 7/10/2026, 11:48:42 PM
1class Solution {
2    public List<Integer> grayCode(int n) {
3        List<Integer> result = new ArrayList<>();
4
5        for (int i = 0; i < (1 << n); i++) {
6            result.add(i ^ (i >> 1));
7        }
8
9        return result;
10    }
11}