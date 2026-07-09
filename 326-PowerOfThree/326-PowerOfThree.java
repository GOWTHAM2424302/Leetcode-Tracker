// Last updated: 7/9/2026, 3:02:03 PM
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}