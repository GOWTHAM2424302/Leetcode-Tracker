// Last updated: 8/28/2026, 9:44:52 AM
1public class Solution {
2    public boolean predictTheWinner(int[] nums) {
3        int n = nums.length;
4        // Even number of elements always guarantees a win for Player 1
5        if (n % 2 == 0) {
6            return true;
7        }
8        
9        // dp[i] stores the maximum score difference for a subarray ending at index i
10        int[] dp = new int[n];
11        
12        // Base case: Subarrays of length 1 (only one element available)
13        for (int i = 0; i < n; i++) {
14            dp[i] = nums[i];
15        }
16        
17        // Build the solution bottom-up for subarrays of length 2 up to n
18        for (int diff = 1; diff < n; diff++) {
19            for (int i = 0; i + diff < n; i++) {
20                int j = i + diff;
21                // Maximum net score by choosing either the left (i) or right (j) element
22                dp[i] = Math.max(nums[i] - dp[i + 1], nums[j] - dp[i]);
23            }
24        }
25        
26        // Player 1 wins if the net score difference for the entire array is non-negative
27        return dp[0] >= 0;
28    }
29}