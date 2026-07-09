// Last updated: 7/9/2026, 3:01:53 PM
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 0) {
                int left = (i == 0) ? 0 : flowerbed[i - 1];
                int right = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];

                if (left == 0 && right == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count >= n;
    }
}