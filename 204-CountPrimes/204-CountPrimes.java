// Last updated: 7/9/2026, 3:02:25 PM
class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;

        boolean[] composite = new boolean[n];
        int count = n / 2;

        for (int i = 3; i * i < n; i += 2) {
            if (!composite[i]) {
                for (int j = i * i; j < n; j += 2 * i) {
                    if (!composite[j]) {
                        composite[j] = true;
                        count--;
                    }
                }
            }
        }

        return count;
    }
}