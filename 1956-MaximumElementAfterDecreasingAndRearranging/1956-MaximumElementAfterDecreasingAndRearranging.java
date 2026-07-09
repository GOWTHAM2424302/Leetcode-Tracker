// Last updated: 7/9/2026, 3:01:06 PM
import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        return arr[arr.length - 1];
    }
}