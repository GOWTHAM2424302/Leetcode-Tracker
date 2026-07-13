// Last updated: 7/13/2026, 12:30:16 PM
1class Solution {
2    public List<String> restoreIpAddresses(String s) {
3        List<String> result = new ArrayList<>();
4        backtrack(s, 0, 0, "", result);
5        return result;
6    }
7
8    private void backtrack(String s, int index, int parts,
9                           String current, List<String> result) {
10
11        if (parts == 4 && index == s.length()) {
12            result.add(current.substring(0, current.length() - 1));
13            return;
14        }
15
16        if (parts == 4 || index == s.length()) {
17            return;
18        }
19
20        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
21            String segment = s.substring(index, index + len);
22
23            if ((segment.length() > 1 && segment.charAt(0) == '0') ||
24                Integer.parseInt(segment) > 255) {
25                continue;
26            }
27
28            backtrack(s, index + len, parts + 1,
29                    current + segment + ".", result);
30        }
31    }
32}