// Last updated: 7/9/2026, 3:00:58 PM
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        int ans = 0;

        for (int num : nums) {
            freq[num]++;
            if (freq[num] > max) {
                max = freq[num];
                ans = max;
            } else if (freq[num] == max) {
                ans += max;
            }
        }

        return ans;
    }
}