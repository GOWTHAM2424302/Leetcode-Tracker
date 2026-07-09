// Last updated: 7/9/2026, 3:03:43 PM
class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;

        while (N > 0) {
            if ((N & 1) == 1) {
                result *= x;
            }

            x *= x;
            N >>= 1;
        }

        return result;
    }
}