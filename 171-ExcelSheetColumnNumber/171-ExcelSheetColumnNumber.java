// Last updated: 7/9/2026, 3:02:57 PM
class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (char c : columnTitle.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }

        return result;
    }
}