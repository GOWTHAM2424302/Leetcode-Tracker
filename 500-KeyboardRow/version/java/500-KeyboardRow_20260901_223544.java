// Last updated: 9/1/2026, 10:35:44 PM
1class Solution {
2    public int reachNumber(int target) {
3        target = Math.abs(target);
4
5        int sum = 0;
6        int steps = 0;
7
8        while (sum < target || (sum - target) % 2 != 0) {
9            steps++;
10            sum += steps;
11        }
12
13        return steps;
14    }
15}