// Last updated: 7/10/2026, 11:56:03 PM
1class Solution {
2    public List<List<Integer>> generate(int numRows) {
3        List<List<Integer>> result = new ArrayList<>();
4
5        for (int i = 0; i < numRows; i++) {
6            List<Integer> row = new ArrayList<>();
7
8            for (int j = 0; j <= i; j++) {
9                if (j == 0 || j == i) {
10                    row.add(1);
11                } else {
12                    row.add(result.get(i - 1).get(j - 1) +
13                            result.get(i - 1).get(j));
14                }
15            }
16
17            result.add(row);
18        }
19
20        return result;
21    }
22}