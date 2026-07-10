// Last updated: 7/10/2026, 11:56:38 PM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int minPrice = Integer.MAX_VALUE;
4        int maxProfit = 0;
5
6        for (int price : prices) {
7            minPrice = Math.min(minPrice, price);
8            maxProfit = Math.max(maxProfit, price - minPrice);
9        }
10
11        return maxProfit;
12    }
13}