// Last updated: 9/8/2026, 12:16:44 PM
1class Solution extends VersionControl {
2
3    public int firstBadVersion(int n) {
4        int left = 1;
5        int right = n;
6
7        while (left < right) {
8            int mid = left + (right - left) / 2;
9
10            if (isBadVersion(mid)) {
11                right = mid;
12            } else {
13                left = mid + 1;
14            }
15        }
16
17        return left;
18    }
19}