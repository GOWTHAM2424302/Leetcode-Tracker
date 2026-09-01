// Last updated: 9/1/2026, 10:28:30 AM
1import java.util.Arrays;
2
3class Solution {
4    public int triangleNumber(int[] nums) {
5        Arrays.sort(nums);
6        int count = 0;
7
8        for (int k = nums.length - 1; k >= 2; k--) {
9            int left = 0;
10            int right = k - 1;
11
12            while (left < right) {
13                if (nums[left] + nums[right] > nums[k]) {
14                    count += right - left;
15                    right--;
16                } else {
17                    left++;
18                }
19            }
20        }
21
22        return count;
23    }
24}