// Last updated: 7/9/2026, 3:00:56 PM
import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        for (long x : freq.keySet()) {
            if (x == 1) {
                int cnt = freq.get(1L);
                if (cnt % 2 == 0) cnt--;
                ans = Math.max(ans, cnt);
                continue;
            }

            long cur = x;
            int len = 0;

            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;
                if (cur > 1000000000L) break;
                cur = cur * cur;
            }

            if (freq.getOrDefault(cur, 0) >= 1)
                len++;
            else
                len--;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}