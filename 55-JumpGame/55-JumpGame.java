// Last updated: 7/9/2026, 3:03:31 PM
class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false;

            reach = Math.max(reach, i + nums[i]);
        }

        return true;
    }
}