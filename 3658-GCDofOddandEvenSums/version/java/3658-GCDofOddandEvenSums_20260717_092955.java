// Last updated: 7/17/2026, 9:29:55 AM
1class Solution {
2    public int binaryGap(int n) {
3        int last = -1;
4        int maxDistance = 0;
5        int position = 0;
6
7        while (n > 0) {
8            if ((n & 1) == 1) {
9                if (last != -1) {
10                    maxDistance = Math.max(maxDistance, position - last);
11                }
12                last = position;
13            }
14            position++;
15            n >>= 1;
16        }
17
18        return maxDistance;
19    }
20}