// Last updated: 7/9/2026, 3:02:59 PM
class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char)('A' + (n - 1) % 26);
    }
}