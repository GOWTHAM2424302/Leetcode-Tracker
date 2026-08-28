// Last updated: 8/28/2026, 9:57:29 AM
1class Solution {
2    public int candy(int[] ratings) {
3        int n = ratings.length;
4        int[] candies = new int[n];
5
6        // Give every child 1 candy
7        for (int i = 0; i < n; i++) {
8            candies[i] = 1;
9        }
10
11        // Left to right
12        // If current rating is higher than left neighbor,
13        // current child gets one more candy.
14        for (int i = 1; i < n; i++) {
15            if (ratings[i] > ratings[i - 1]) {
16                candies[i] = candies[i - 1] + 1;
17            }
18        }
19
20        // Right to left
21        // If current rating is higher than right neighbor,
22        // make sure current child has more candies.
23        for (int i = n - 2; i >= 0; i--) {
24            if (ratings[i] > ratings[i + 1]) {
25                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
26            }
27        }
28
29        // Calculate total
30        int total = 0;
31
32        for (int candy : candies) {
33            total += candy;
34        }
35
36        return total;
37    }
38}