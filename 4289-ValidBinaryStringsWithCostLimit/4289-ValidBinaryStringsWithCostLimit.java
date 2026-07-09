// Last updated: 7/9/2026, 3:00:43 PM
import java.util.*;

class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> result = new ArrayList<>();
        backtrack(0, n, k, 0, false, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int idx, int n, int k, int cost,
                           boolean prevOne, StringBuilder sb,
                           List<String> result) {

        if (cost > k) return;

        if (idx == n) {
            result.add(sb.toString());
            return;
        }

        // Place '0'
        sb.append('0');
        backtrack(idx + 1, n, k, cost, false, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        // Place '1' if previous character is not '1'
        if (!prevOne) {
            sb.append('1');
            backtrack(idx + 1, n, k, cost + idx, true, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}