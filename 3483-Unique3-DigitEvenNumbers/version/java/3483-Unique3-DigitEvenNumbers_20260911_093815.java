// Last updated: 9/11/2026, 9:38:15 AM
1class Solution {
2    public int totalNumbers(int[] digits) {
3        boolean[] used = new boolean[digits.length];
4        java.util.HashSet<Integer> set = new java.util.HashSet<>();
5
6        for (int i = 0; i < digits.length; i++) {
7            if (digits[i] == 0) continue;
8            used[i] = true;
9
10            for (int j = 0; j < digits.length; j++) {
11                if (used[j]) continue;
12                used[j] = true;
13
14                for (int k = 0; k < digits.length; k++) {
15                    if (used[k] || digits[k] % 2 != 0) continue;
16
17                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
18                    set.add(num);
19                }
20
21                used[j] = false;
22            }
23
24            used[i] = false;
25        }
26
27        return set.size();
28    }
29}