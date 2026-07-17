// Last updated: 7/17/2026, 9:25:57 AM
1class Solution {
2    public int[] gcdValues(int[] nums, long[] queries) {
3        int max = 0;
4        for (int x : nums) max = Math.max(max, x);
5
6        int[] freq = new int[max + 1];
7        for (int x : nums) freq[x]++;
8
9        long[] divisibleCount = new long[max + 1];
10        for (int g = 1; g <= max; g++) {
11            for (int multiple = g; multiple <= max; multiple += g) {
12                divisibleCount[g] += freq[multiple];
13            }
14        }
15
16        long[] gcdExact = new long[max + 1];
17
18        for (int g = max; g >= 1; g--) {
19            long cnt = divisibleCount[g];
20            gcdExact[g] = cnt * (cnt - 1) / 2;
21
22            for (int multiple = g * 2; multiple <= max; multiple += g) {
23                gcdExact[g] -= gcdExact[multiple];
24            }
25        }
26
27        long[] prefix = new long[max + 1];
28        for (int g = 1; g <= max; g++) {
29            prefix[g] = prefix[g - 1] + gcdExact[g];
30        }
31
32        int[] answer = new int[queries.length];
33
34        for (int i = 0; i < queries.length; i++) {
35            long target = queries[i] + 1;
36
37            int left = 1, right = max;
38            while (left < right) {
39                int mid = left + (right - left) / 2;
40
41                if (prefix[mid] >= target) {
42                    right = mid;
43                } else {
44                    left = mid + 1;
45                }
46            }
47
48            answer[i] = left;
49        }
50
51        return answer;
52    }
53}