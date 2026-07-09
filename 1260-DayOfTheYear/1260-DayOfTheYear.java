// Last updated: 7/9/2026, 3:01:20 PM
class Solution {
    public int dayOfYear(String date) {
        String[] p = date.split("-");
        int year = Integer.parseInt(p[0]);
        int month = Integer.parseInt(p[1]);
        int day = Integer.parseInt(p[2]);

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            days[1] = 29;
        }

        int ans = day;

        for (int i = 0; i < month - 1; i++) {
            ans += days[i];
        }

        return ans;
    }
}